package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ChangePassDto;
import com.app.entities.User;
import com.app.services.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	// this method return  HTTP status of OK (200) and the message "Registration Successful".
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user)
	{
		
		//System.out.println(user);
		userService.register(user);
		return ResponseEntity.ok("Registration Successful");
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestParam String email, @RequestParam String passw)
	{
		User user = userService.login(email, passw);
		if(user!=null)
		{
			return ResponseEntity.ok(user);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUserById(@PathVariable Long id)
//	{
//		User user = userService.findById(id);
//		if(user!=null)
//		{
//			return ResponseEntity.ok(user);
//		}
//		else
//		{
//			return ResponseEntity.notFound().build();
//		}
//	}
	
//	@PostMapping("/byFirstName")
//	public ResponseEntity<List<User>> getUsersByFirstName(@RequestParam String fname)
//	{
//	
//			List<User> users = userService.findByFirstName(fname);
//			if(users.isEmpty())
//			{
//				return ResponseEntity.ok(users);
//			}
//			else
//			{
//				return ResponseEntity.notFound().build();
//			}
//	}
	
//	@PostMapping("/updatePassword")
//	public ResponseEntity<String> passwordUpdate(@RequestBody ChangePassDto changePass, @PathVariable Long id)
//	{
//		changePass.setUserId(id);
//		return userService.setNewPassword(changePass);
//	}
	

	
	@PutMapping("/{userId}/UpdatePassword")
    public ResponseEntity<String> updatePassword(
            @PathVariable Long userId,
            @RequestParam String email,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {
        
        try {
            userService.updatePassword(userId, email, oldPassword, newPassword);
            return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
	

}
