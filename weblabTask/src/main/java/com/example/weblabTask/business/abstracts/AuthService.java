package com.example.weblabTask.business.abstracts;

import com.example.weblabTask.core.utilities.results.DataResult;
import com.example.weblabTask.core.utilities.results.Result;
import com.example.weblabTask.entities.DTOs.UserForLoginDto;
import com.example.weblabTask.entities.DTOs.UserForRegisterDto;
import com.example.weblabTask.entities.concretes.User;

public interface AuthService {

	
	
	 DataResult<User> Register(UserForRegisterDto userforRegisterDto, String password);
	 DataResult<User> Login(UserForLoginDto useForLoginDto);
	 Result UserExists(String email);
	 
	 
	

}
