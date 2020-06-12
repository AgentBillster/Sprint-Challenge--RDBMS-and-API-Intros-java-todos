package com.sprint.sprintr.services;

import com.sprint.sprintr.models.Users;

import java.util.List;

public interface UserServices {
    List<Users> getAllUsers();
    Users getUserById(long id);
}
