package com.app.services;

import java.sql.Date;
import java.util.List;

import com.app.dto.BookingDto;
import com.app.entities.Bookings;
import com.app.entities.Catering;
import com.app.entities.Hotel;
import com.app.entities.User;

public interface BookingService {
	
	Bookings findById(Long id);
	
	Bookings findByBookingName(String name);
	
	public Bookings createBooking(Long userId, List<String> hotelNames, String cateringNames,
            boolean photographerRequired, boolean makeupArtistRequired);
	
	public String createBooking(BookingDto bookingDto);

	Bookings createBooking(Long id, List<String> hotelNames, List<String> cateringNames, Boolean photographer,
			Boolean makeupartist); 
}
	
	





