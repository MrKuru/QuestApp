package com.project.questapp.controller;

import com.project.questapp.entities.User;
import com.project.questapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public User getOneUserById(@PathVariable Long userId) {
        return userService.getOneUserById(userId);
    }

    @PutMapping("/[{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateOneUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteOneUser(userId);
    }
}
