package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dto.ChangePassDto;
import com.app.entities.User;
import com.app.repository.UserRepo;
import com.app.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User register(User user) {

		return userRepo.save(user);
	}

	@Override
	public User login(String email, String password) {
		
		User user = userRepo.findByEmail(email);
		if(user!=null && user.getPassword().equals(password))
		{
			return user;
		}
		return null; // "Invaild Username or Password"
	}

	@Override
	public User findById(Long userId) {
		
		return userRepo.findById(userId).orElseThrow();
	}

	@Override
	public List<User> findByFirstName(String name) {
	
		return userRepo.findByfirstName(name);
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}

	@Override
	public String updateUser(User user) {
		User u = userRepo.findById(user.getId()).orElseThrow();
		ModelMapper maper = new ModelMapper();
		maper.map(user, u);
		
		return "User Updated";
	}

	@Override
	public ResponseEntity<String> setNewPassword(ChangePassDto changePassword) {
		
//		User user = userRepo.findById(changePassword.getUserId()).orElseThrow();
//		if(user.getPassword().equals(changePassword.getOldPass()))
//		{
//			user.setPassword(changePassword.getNewPass());
//			return ResponseEntity.ok("Password Updated Successfully");
//		}
//		else
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Old Password is incorrect");
		
		
		User user = userRepo.findById(changePassword.getUserId()).orElseThrow();
		return null;
		
	}

	
	public void updatePassword(Long userId, String email, String oldPassword, String newPassword) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Check if the email and old password match the credentials in the database
        if (!user.getEmail().equals(email) || !user.getPassword().equals(oldPassword)) {
            throw new IllegalArgumentException("Invalid email or password");
        }

  
        user.setPassword(newPassword);
        userRepo.save(user);
    }

}
