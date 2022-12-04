package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateOneUser(Long userId, User user) {
        Optional<User> updatableUser = userRepository.findById(userId);
        if (updatableUser.isPresent()) {
            User foundUser = updatableUser.get();
            foundUser.setUserName(user.getUserName());
            foundUser.setPassword(user.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    @Override
    public void deleteOneUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
