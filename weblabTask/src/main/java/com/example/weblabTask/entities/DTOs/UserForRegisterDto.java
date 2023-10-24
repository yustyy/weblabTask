package com.example.weblabTask.entities.DTOs;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForRegisterDto {

	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String nationalityId;
	
	private BigInteger phoneNumber;
	
	
}
