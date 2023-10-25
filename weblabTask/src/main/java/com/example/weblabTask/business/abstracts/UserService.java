package com.example.weblabTask.business.abstracts;

import java.util.List;

import com.example.weblabTask.core.utilities.results.DataResult;
import com.example.weblabTask.core.utilities.results.Result;
import com.example.weblabTask.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	
	Result Add(User user);
	
	DataResult<User> getByEmail(String email);
	
	DataResult<User> getByNationalityId(String nationalityId);

	
	
}
