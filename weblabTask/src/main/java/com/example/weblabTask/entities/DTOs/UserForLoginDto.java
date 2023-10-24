package com.example.weblabTask.entities.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserForLoginDto {

	private String email;
	
	private String password;
	
	
}
