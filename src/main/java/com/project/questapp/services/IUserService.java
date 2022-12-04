package com.project.questapp.services;

import com.project.questapp.entities.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User createUser(User user);

    User getOneUserById(Long userId);

    User updateOneUser(Long userId, User user);

    void deleteOneUser(Long userId);
}
