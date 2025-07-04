package com.exception.exception_handler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exception.exception_handler.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
