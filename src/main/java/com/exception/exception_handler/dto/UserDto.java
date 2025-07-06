package com.exception.exception_handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;    
    private String role;
    private String status;
    private String address;


}
