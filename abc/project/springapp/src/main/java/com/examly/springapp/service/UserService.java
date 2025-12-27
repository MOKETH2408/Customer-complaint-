package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User addUser(User user)
    {
        return userRepo.save(user);
    }
    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }
}
