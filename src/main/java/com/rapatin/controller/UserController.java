package com.rapatin.controller;

import com.rapatin.entities.User;
import com.rapatin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @PostMapping(value = "/user")
    public User create(@RequestBody User newUser){
        return userService.create(newUser);
    }

    @PatchMapping(value = "/user")
    public User update(@RequestBody User newUser){
        return userService.update(newUser);
    }

    @DeleteMapping(value = "/user")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }
}

