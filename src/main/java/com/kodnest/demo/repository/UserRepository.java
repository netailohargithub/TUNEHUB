package com.kodnest.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.demo.entity.User;

public interface UserRepository 
extends JpaRepository<User, String>{

	public User findByEmail(String email);

}