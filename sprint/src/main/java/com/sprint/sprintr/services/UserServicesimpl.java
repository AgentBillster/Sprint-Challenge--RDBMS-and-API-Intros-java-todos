package com.sprint.sprintr.services;


import com.sprint.sprintr.models.Todos;
import com.sprint.sprintr.models.Users;
import com.sprint.sprintr.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userServices")
public class UserServicesimpl implements UserServices {


    @Autowired
    private UsersRepo userRepo;

    @Transactional
    @Override
    public List<Users> getAllUsers() {
        List<Users> list = new ArrayList<>();
        userRepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Users getUserById(long id) throws
            EntityNotFoundException {
        return userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user" + id + "not found"));
    }


    // 2. GENERATE OVVERIDE METHODS STARTING WITH DELETE make all methods transactional do all or none
    @Transactional
    @Override
    public void delete(long id) {
        if (userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Restaurant" + id + "not found");
        }
    }

    // 3. DO SAVE VERIFY ALL DATA RUN ALL BASE METHOEDS THROUGH SETTER then lists
    // THIS DOES A POST AND A PUT depending on if there is id or not
    @Transactional
    @Override
    public Users save(Users users) {
        Users newUsers = new Users();

        if (users.getUserid() != 0) {
            //put
            userRepo.findById(users.getUserid())
                    .orElseThrow(() -> new EntityNotFoundException("user " + users.getUserid() + "not found"));


            newUsers.setUserid(users.getUserid());
        }

        newUsers.setPassword(users.getPassword());
        newUsers.setPrimaryemail(users.getPrimaryemail());
        newUsers.setUsername(users.getUsername());

        newUsers.getTodos().clear();

        for (Todos t : users.getTodos()) {
            Todos newTodo = new Todos(t.getUser(), t.getDescription());
            newUsers.getTodos().add(newTodo);
        }
        return userRepo.save(newUsers);
    }
}