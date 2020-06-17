package com.sprint.sprintr.services;


import com.sprint.sprintr.models.Todos;
import com.sprint.sprintr.models.Users;
import com.sprint.sprintr.repos.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class TodoServicesimpl implements TodoServices {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserServices userservice;



    @Transactional
    @Override
    public Todos save(Todos todo, long userid) {
        Todos newTodo = new Todos();
        newTodo.setDescription(todo.getDescription());
        newTodo.setUser(userservice.getUserById(userid));
        return todoRepo.save(newTodo);
    }

    @Transactional
    @Override
    public Todos update(Todos todo, long id) {
        Todos currentTodo = todoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo " + id + " not found"));

        if (todo.getDescription() != null) {
            currentTodo.setDescription(todo.getDescription());
        }
        if (todo.getUser() != null) {
            currentTodo.setUser(todo.getUser());
        }


        if (todo.isCompleted()) {
            currentTodo.setCompleted(true);
        } else {
            currentTodo.setCompleted(false);

        }

        return todoRepo.save(currentTodo);
    }

}
