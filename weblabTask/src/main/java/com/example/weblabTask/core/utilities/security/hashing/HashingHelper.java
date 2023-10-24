package com.example.weblabTask.core.utilities.security.hashing;

import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.example.weblabTask.entities.DTOs.PasswordHashDto;

public class HashingHelper {

	
	public static PasswordHashDto CreatePasswordHash(String password){
	
		
		PasswordHashDto passwordHashDto = new PasswordHashDto();
		
		try {
			
			
			//generates passwordHash
			SecureRandom random = new SecureRandom();
			byte[] salt = new byte[64];
			random.nextBytes(salt);
			passwordHashDto.setPasswordSalt(salt); 
			
			
			//hashes the password that sent 
			SecretKey key = new SecretKeySpec(salt, "HmacSHA512");
			Mac mac = Mac.getInstance("HmacSHA512");
			mac.init(key);
			var hash = mac.doFinal(password.getBytes("UTF-8"));
			passwordHashDto.setPasswordHash(hash);
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			
		}
		
		return passwordHashDto;
		
		
	}
	
	
	
	
	public static boolean VerifyPasswordHash(String password, byte[] passwordHash, byte[] passwordSalt) {
		
		try {
			SecretKey key = new SecretKeySpec(passwordSalt, "HmacSHA512");
			Mac mac = Mac.getInstance("HmacSHA512");
			mac.init(key);
			
			byte[] computedHash = mac.doFinal(password.getBytes("UTF-8"));
			
			return Arrays.equals(computedHash, passwordHash);
				
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
