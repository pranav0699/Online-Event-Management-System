package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Admin;
import com.app.entities.Bookings;
import com.app.entities.Catering;
import com.app.entities.Hotel;
import com.app.entities.User;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
	
	//User findbyEmail(String email);
	
	//User saveUser(User user);
	
	//User updateUser(User user);
	
	//void deleteUserById(Long userId);
	
	// Retrieve booking details of a specific user
//    List<Bookings> findBookingsByUserId(Long userId);

    // Retrieve hotel booking details
//    List<Hotel> findAllHotels();

    // Retrieve catering details
//    List<Catering> findAllCaterings();
    
    Admin findByEmailAndPassword(String email, String password);
    
    Admin findByEmail(String email);

}
