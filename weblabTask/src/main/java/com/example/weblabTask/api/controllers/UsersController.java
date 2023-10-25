package com.example.weblabTask.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weblabTask.business.abstracts.UserService;
import com.example.weblabTask.core.utilities.results.DataResult;
import com.example.weblabTask.core.utilities.results.Result;
import com.example.weblabTask.entities.concretes.User;

@RestController
@RequestMapping("api/users")
public class UsersController {
	
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<User>> GetAll(){
		return userService.getAll();
		}
	

}
