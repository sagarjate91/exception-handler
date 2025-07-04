package com.exception.exception_handler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.exception_handler.model.User;
import com.exception.exception_handler.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User partialUpdateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            if (user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                existingUser.setPassword(user.getPassword());
            }
            if (user.getRole() != null) {
                existingUser.setRole(user.getRole());
            }
            if (user.getStatus() != null) {
                existingUser.setStatus(user.getStatus());
            }
            if (user.getAddress() != null) {
                existingUser.setAddress(user.getAddress());
            }
            return userRepository.save(existingUser);
        }
        return null;
    }

}
