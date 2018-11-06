package com.sit.SoftwareProcess.SoftwareProcess.Service;

import com.sit.SoftwareProcess.SoftwareProcess.Model.User;
import com.sit.SoftwareProcess.SoftwareProcess.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(long userId) {
        return userRepository.getOne(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
