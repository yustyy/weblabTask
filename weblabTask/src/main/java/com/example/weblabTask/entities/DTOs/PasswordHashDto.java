package com.example.weblabTask.entities.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordHashDto {
	
	
	private byte[] passwordHash;
	
	private byte[] passwordSalt;
	
	
	

}
