package com.exception.utility;

import com.exception.exception_handler.dto.UserDto;
import com.exception.exception_handler.model.User;

public class Utility {

    public static User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setStatus(userDto.getStatus());
        user.setAddress(userDto.getAddress());
        return user;
    }

    public static  UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setStatus(user.getStatus());
        userDto.setAddress(user.getAddress());
        return userDto;
    }

    public static int get(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0; // or handle the error as needed
        }
    }

}
