package com.sprint.sprintr.services;


import com.sprint.sprintr.models.Users;
import com.sprint.sprintr.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "UserServices")
public class UserServicesimpl implements UserServices {


    @Autowired
    private UsersRepo restrepos;

    @Override
    public List<Users> getAllUsers() {
        List<Users> list = new ArrayList<>();
        restrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Users getUserById(long id) throws
            EntityNotFoundException {
        return restrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user" + id + "not found"));
    }

}