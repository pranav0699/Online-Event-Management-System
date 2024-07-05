package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);
	
	List<User> findByfirstName(String fname);

}
