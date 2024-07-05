package com.app.services;

import java.util.List;

import com.app.dto.HotelDto;
import com.app.entities.Catering;
import com.app.entities.Hotel;

public interface HotelService { 
	
	Hotel findById(Long hotelId);
	
	Hotel findByName(String hotelName);
	
	String hotelUpdate(Hotel hotel);
	
	Hotel addHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();

	Hotel addHotel(HotelDto hotel);
	
	void updateHotel(String hotelName, Hotel updatedHotel);
	
	public String updateHotel(Hotel hotel);

}
