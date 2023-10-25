package com.example.weblabTask.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weblabTask.business.abstracts.AuthService;
import com.example.weblabTask.business.abstracts.UserService;
import com.example.weblabTask.business.constants.Messages;
import com.example.weblabTask.core.utilities.results.DataResult;
import com.example.weblabTask.core.utilities.results.ErrorDataResult;
import com.example.weblabTask.core.utilities.results.Result;
import com.example.weblabTask.core.utilities.results.SuccessDataResult;
import com.example.weblabTask.core.utilities.security.hashing.HashingHelper;
import com.example.weblabTask.entities.DTOs.PasswordHashDto;
import com.example.weblabTask.entities.DTOs.UserForLoginDto;
import com.example.weblabTask.entities.DTOs.UserForRegisterDto;
import com.example.weblabTask.entities.concretes.User;

@Service
public class AuthManager implements AuthService {

	
	private UserService userService;
	
	@Autowired
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@Override
	public DataResult<User> Register(UserForRegisterDto userForRegisterDto, String password) {
		
		if(userService.getByEmail(userForRegisterDto.getEmail()).isSuccess()) {
			return new ErrorDataResult<User>(Messages.ThisEmailAlreadyInUse);
		}
		
		if(checkIfNationalityIdExists(userForRegisterDto.getNationalityId())) {
			return new ErrorDataResult<User>(Messages.ThisNationalityIdAlreadyExists);
		}
		
		
		
		PasswordHashDto passwordHashDto = HashingHelper.CreatePasswordHash(password);
		
		
		var userToRegister = new User();
		userToRegister.setEmail(userForRegisterDto.getEmail());
		userToRegister.setFirstName(userForRegisterDto.getFirstName());
		userToRegister.setLastName(userForRegisterDto.getLastName());
		userToRegister.setNationalityId(userForRegisterDto.getNationalityId());
		userToRegister.setPhoneNumber(userForRegisterDto.getPhoneNumber());
		
		userToRegister.setPasswordHash(passwordHashDto.getPasswordHash());
		userToRegister.setPasswordSalt(passwordHashDto.getPasswordSalt());
		
		
		userService.Add(userToRegister);
		var user = userService.getByEmail(userToRegister.getEmail()).getData();
		
		
		return new SuccessDataResult<User>(user, Messages.UserSuccessfullyRegistered);
		
	
		
		
		
	}

	private boolean checkIfNationalityIdExists(String nationalityId) {
		
		var user = userService.getByNationalityId(nationalityId);
		
		if(user.isSuccess()) {
			return false;
		}
		return true;
		
		
	}


	@Override
	public DataResult<User> Login(UserForLoginDto userForLoginDto) {
		var userToCheck = userService.getByEmail(userForLoginDto.getEmail()).getData();
		
		if(userToCheck == null) {
			return new ErrorDataResult<User>(Messages.ThisEmailDoesntExists);
		}
		
		
		if(!HashingHelper.VerifyPasswordHash(userForLoginDto.getPassword(), userToCheck.getPasswordHash(), userToCheck.getPasswordSalt())){
			return new ErrorDataResult<User>(Messages.PassworIsdWrong);
		}
		
		return new SuccessDataResult<User>(userToCheck, Messages.SuccessfulLogin);
		
		
	}
		
		

	@Override
	public Result UserExists(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
