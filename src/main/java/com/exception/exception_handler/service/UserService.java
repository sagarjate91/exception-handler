package com.exception.exception_handler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.exception_handler.dto.UserDto;
import com.exception.exception_handler.model.User;
import com.exception.exception_handler.repository.UserRepository;
import com.exception.utility.Utility;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(Utility::userToUserDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        return Utility.userToUserDto(userRepository.findById(id).orElse(null));
    }

    public UserDto createUser(UserDto user) {
        return Utility.userToUserDto(userRepository.save(Utility.userDtoToUser(user)));
    }

    public UserDto updateUser(Long id, UserDto user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return Utility.userToUserDto(userRepository.save(Utility.userDtoToUser(user)));
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto partialUpdateUser(Long id, UserDto user) {
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
            return Utility.userToUserDto(userRepository.save(existingUser));
        }
        return null;
    }

}
