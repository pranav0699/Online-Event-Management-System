package com.app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.ChangePassDto;
import com.app.entities.User;

public interface UserService {
	
	User register(User user);
	
	User login (String email,String password);
	
	User findById(Long userId);
	
	List<User> findByFirstName(String name);
	
	User findByEmail(String email);
	
	String updateUser(User user);
	
	public ResponseEntity<String> setNewPassword(ChangePassDto changePassword);
	
	//void updatePassword(Long userId, String newPassword);
	
	public void updatePassword(Long userId, String email, String oldPassword, String newPassword);
	
	

}
