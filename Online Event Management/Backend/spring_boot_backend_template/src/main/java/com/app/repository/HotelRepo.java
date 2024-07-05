package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long>{
	
	//Hotel findById(Long hotelId);
	
	Hotel findByhotelName(String hotelName);
	
	List<Hotel> findByHotelNameIn(List<String> hotelNames);

}
