package com.example.weblabTask.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.weblabTask.entities.concretes.User;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	
	User findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	User findByNationalityId(String string);
}
