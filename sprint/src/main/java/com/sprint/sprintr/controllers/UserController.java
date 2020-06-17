package com.sprint.sprintr.controllers;


import com.sprint.sprintr.models.Users;
import com.sprint.sprintr.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userService;


    @GetMapping(value = "/users",
            produces = {"application/json"})
    public ResponseEntity<?> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return new ResponseEntity<>(users,
                HttpStatus.OK);
    }


    @GetMapping(value = "/user/{userid}",
            produces = {"application/json"})
    public ResponseEntity<?> getUserById(
            @PathVariable
                    Long userid) {
        Users u = userService.getUserById(userid);
        return new ResponseEntity<>(u,
                HttpStatus.OK);
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    public ResponseEntity<?> save(@Validated @RequestBody Users newUsers) {
        newUsers.setUserid(0);
        newUsers = userService.save(newUsers);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newUsers.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/userid/{userid}", produces = {"application/json"})
    public ResponseEntity<?> delete(@PathVariable long userid) {
        userService.delete(userid);
        return new ResponseEntity<>(userid, HttpStatus.OK);
    }


}

//DELETE /users/userid/{userid} --
//POST /users/user - adds a user. --