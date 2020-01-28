package com.rapatin.services;

import com.rapatin.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User create (User newUSer);
    User update (User newUser);
    void delete(Integer id);
}