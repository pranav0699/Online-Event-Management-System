package com.app.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.app.entities.Admin;
import com.app.entities.Bookings;
import com.app.entities.Catering;
import com.app.entities.Hotel;
import com.app.entities.User;
import com.app.repository.AdminRepo;
import com.app.repository.UserRepo;

@Service
@Transactional

public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

//	@Autowired
//	private UserRepo usrRepo;
	
	
	
//	@Override
//	public User addUser(@Valid User user) {
//		
//		return usrRepo.save(user);
//	}
//
//	@Override
//	public User updateUser(@Valid User user) {
//		
//	User u=usrRepo.findById(user.getId()).orElseThrow();
//	ModelMapper map=new ModelMapper();
//	map.map(u, user);
//		return u;
//	}

//	@Override
//	public void deleteUser(Long userId) {
//		adminRepo.deleteById(userId);
//		
//	}

//	@Override
//	public List<Bookings> getUserBookings(Long id) {
//	
//		return adminRepo.findBookingsByUserId(id);
//	}

//	@Override
//	public List<Hotel> getAllHotels() {
//		
//		return adminRepo.findAllHotels();
//	}

//	@Override
//	public List<Catering> getAllCaterings() {
//		
//		return adminRepo.findAllCaterings();
//	}

	@Override
	public  Admin registerAdmin( Admin admin) {
		
		return adminRepo.save(admin);
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		
		return adminRepo.findByEmailAndPassword(email, password);
	}

}
