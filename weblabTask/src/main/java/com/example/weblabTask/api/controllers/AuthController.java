package com.example.weblabTask.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weblabTask.business.abstracts.AuthService;
import com.example.weblabTask.core.utilities.results.DataResult;
import com.example.weblabTask.entities.DTOs.UserForLoginDto;
import com.example.weblabTask.entities.DTOs.UserForRegisterDto;
import com.example.weblabTask.entities.concretes.User;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public DataResult<User> Register(@RequestBody UserForRegisterDto userForRegisterDto){
		return authService.Register(userForRegisterDto, userForRegisterDto.getPassword());
		
	}
	
	@PostMapping("/login")
	public DataResult<User> Login(@RequestBody UserForLoginDto userForLoginDto){
		return authService.Login(userForLoginDto);
	}
	


}
