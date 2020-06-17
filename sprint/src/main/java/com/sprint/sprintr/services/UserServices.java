package com.sprint.sprintr.services;

import com.sprint.sprintr.models.Users;

import java.util.List;

public interface UserServices {
    List<Users> getAllUsers();

    Users getUserById(long id);


    // 1. MAKE THE METHODS( i made them all here cuz i got lazy)
    void delete(long id);

    Users save(Users users);

}
