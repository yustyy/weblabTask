package com.example.weblabTask.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weblabTask.business.abstracts.UserService;
import com.example.weblabTask.business.constants.Messages;
import com.example.weblabTask.core.utilities.results.DataResult;
import com.example.weblabTask.core.utilities.results.ErrorDataResult;
import com.example.weblabTask.core.utilities.results.Result;
import com.example.weblabTask.core.utilities.results.SuccessDataResult;
import com.example.weblabTask.core.utilities.results.SuccessResult;
import com.example.weblabTask.dataAccess.abstracts.UserDao;
import com.example.weblabTask.entities.concretes.User;

@Service
public class UserManager implements UserService {

	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll(), Messages.AllUsersSelected);
	}



	@Override
	public Result Add(User user) {
		userDao.save(user);
		
		return new SuccessResult(Messages.UserAdded);
		
	}



	@Override
	public DataResult<User> getByEmail(String email) {
		
		if(!userDao.existsByEmail(email)){
			return new ErrorDataResult<User>(Messages.ThisEmailDoesntExists);
		}
		
		
		return new SuccessDataResult<User>(userDao.findByEmail(email), Messages.UserRetrievedWithEmail);
	}





	
	

}
