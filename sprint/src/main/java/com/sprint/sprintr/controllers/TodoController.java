package com.sprint.sprintr.controllers;

import com.sprint.sprintr.models.Todos;
import com.sprint.sprintr.services.TodoServices;
import com.sprint.sprintr.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoServices todoService;

    @Autowired
    private UserServices userService;

    @PatchMapping(value = "/todo/{todoid}", consumes = {"application/json"})
    public ResponseEntity<?> update(@RequestBody Todos updateTodo,
                                     @PathVariable long todoid) {
        updateTodo.setUser(userService.getUserById(todoid));
        return new ResponseEntity<>(todoService.save(updateTodo, todoid), HttpStatus.CREATED);
    }


    @PostMapping(value = "/user/{id}", consumes = {"application/json"})
    public ResponseEntity<?> save(@RequestBody Todos newTodo, @PathVariable long id) {
        newTodo.setUser(userService.getUserById(id));
        return new ResponseEntity<>(todoService.save(newTodo, id), HttpStatus.CREATED);
    }
}


//POST /todos/user/{userid}
//PATCH /todos/todo/{todoid} - mark a todo as completed.