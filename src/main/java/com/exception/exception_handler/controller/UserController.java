package com.exception.exception_handler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.exception_handler.dto.UserDto;
import com.exception.exception_handler.exception.CustomException;
import com.exception.exception_handler.service.UserService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ApiResponse(responseCode = "200", description = "Fetch all users")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @ApiResponse(responseCode = "404", description = "Users not found")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "201", description = "Users fetched successfully")
    @ApiResponse(responseCode = "202", description = "Request accepted")
    @ApiResponse(responseCode = "204", description = "No Content")
    @ApiResponse(responseCode = "301", description = "Moved Permanently")
    @ApiResponse(responseCode = "302", description = "Found")
    @ApiResponse(responseCode = "303", description = "See Other")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/users/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/users/update/{id}")
    public ResponseEntity<UserDto> partialUpdateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.partialUpdateUser(id, user));
    }

    @GetMapping("/users/exception")
    public ResponseEntity<String> throwException() {
        throw new CustomException("This is a custom exception message");
    }

    @GetMapping("/users/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Test endpoint is working!");
    }

}
