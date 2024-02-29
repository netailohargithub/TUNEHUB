package com.kodnest.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.demo.entity.User;
import com.kodnest.demo.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl serviceImpl;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) 
	{
		//email taken from registration form
		String email = user.getEmail();

		//checking if the email as entered in registration  form 
		// is present in DB or not.
		boolean status = serviceImpl.emailExists(email);

		if(status == false) {
			serviceImpl.addUser(user);
			System.out.println("User added");
		}
		else {
			System.out.println("User already exists");
		}

		return "login";
	}


	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {

		if(serviceImpl.validateUser(email, password) == true){
			
			String role = serviceImpl.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminhome";
			}
			else {
				return "customerhome";
			}
		}	
		else {
			return "login";
		}	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
}