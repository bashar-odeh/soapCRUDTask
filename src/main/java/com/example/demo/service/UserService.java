package com.example.demo.service;

import com.example.demo.repositories.UserRepository;
import com.techprimers.spring_boot_soap_example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String name) {
        Optional<User> user = userRepository.findUserByName(name);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User updateUser(User newUser) {
        Optional<User> userOptional = userRepository.findById(newUser.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(newUser.getName());
            user.setSalary(newUser.getSalary());
            userRepository.save(user);
            return newUser;
        }
        return null;
    }

    public void addUser(User user) {
        userRepository.insert(user);
    }

    public User getUserById(int empId) {
        Optional<User> opt = userRepository.findById(empId);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    public User deleteUser(String name) {
        Optional<User> opt = userRepository.findUserByName(name);
        if (opt.isPresent()) {
            userRepository.delete(opt.get());
           return opt.get();
        }
        return null;
    }
}
