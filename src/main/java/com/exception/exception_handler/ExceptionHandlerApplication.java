package com.exception.exception_handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exception.exception_handler.dto.UserDto;
import com.exception.exception_handler.model.User;

@SpringBootApplication
public class ExceptionHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionHandlerApplication.class, args);
    }

    //@PostConstruct
    public void init() {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setName("Sagar");
        userDto.setEmail("s@gmail.com");
        userDto.setPassword("sagar123");
        userDto.setRole("Admin");
        userDto.setStatus("Active");
        userDto.setAddress("Pune, India");

		System.out.println("UserDto initialized: " + userDto);

		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setStatus(userDto.getStatus());
		user.setAddress(userDto.getAddress());	
		System.out.println("User initialized: " + user);





    }

}
