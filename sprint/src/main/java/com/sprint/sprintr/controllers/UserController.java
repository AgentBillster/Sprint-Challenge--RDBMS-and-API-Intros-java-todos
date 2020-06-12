package com.sprint.sprintr.controllers;


import com.sprint.sprintr.models.Users;
import com.sprint.sprintr.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

@Autowired
    private UserServices userServices;


    @GetMapping(value = "/users",
            produces = {"application/json"})
    public ResponseEntity<?> getAllUsers() {
        List<Users> users = userServices.getAllUsers();
        return new ResponseEntity<>(users,
                HttpStatus.OK);
    }


    @GetMapping(value = "/user/{userid}",
            produces = {"application/json"})
    public ResponseEntity<?> getUserById(
            @PathVariable
                    Long userid) {
        Users u = userServices.getUserById(userid);
        return new ResponseEntity<>(u,
                HttpStatus.OK);
    }


}
