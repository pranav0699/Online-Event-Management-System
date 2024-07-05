
package com.app.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BookingDto;
import com.app.entities.Bookings;
import com.app.entities.Catering;
import com.app.entities.Hotel;
import com.app.entities.User;
import com.app.repository.BookingRepo;
import com.app.repository.CateringRepo;
import com.app.repository.HotelRepo;
import com.app.repository.UserRepo;

@Service
@Transactional
public class BookingServiceimpl implements BookingService {

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private HotelRepo hotelRepository;

	@Autowired
	private CateringRepo cateringRepository;

	@Autowired
	private BookingRepo bookingRepository;

	
	
	@Override
	public Bookings findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public Bookings createBooking(Long userId, List<String> hotelNames, String cateringNames,
//	                              boolean photographerRequired, boolean makeupArtistRequired) {
//	    // Find the user by userId
//	    User user = userRepository.findById(userId)
//	            .orElseThrow(() -> new IllegalArgumentException("User not found"));
//
//	    // Find hotels by hotel names
//	    List<Hotel> hotels = hotelRepository.findByHotelNameIn(hotelNames);
//	    if (hotels.size() != hotelNames.size()) {
//	        throw new IllegalArgumentException("One or more hotels not found");
//	    }
//
//	    // Find caterings by catering names
//	    List<Catering> caterings = cateringRepository.findByCaterName(cateringNames);
//	    if (caterings.size() != cateringNames.length()) {
//	        throw new IllegalArgumentException("One or more caterings not found");
//	    }
//
//	    // Create a new booking
//	    Bookings booking = new Bookings();
//	    booking.setUser(user);
//	    booking.setHotel(hotels); // Set the list of hotels
//	    booking.setCatering(caterings);
//	    booking.setEvent_date(new Date(userId)); // Set event_date to current date/time
//	    // Set other properties of the booking as needed
//	    // booking.setMax_total_hour(maxTotalHour);
//	    // booking.setAmount(amount);
//	    // booking.setNo_of_guest(noOfGuest);
//	    // booking.setPhotographer_name_desc(photographerRequired);
//	    // booking.setMakeupartist_name_desc(makeupArtistRequired);
//	    // booking.setPayment_status(false); // Assuming this is set to false by default
//
//	    // Save the booking to the database
//	    return bookingRepository.save(booking);
//	}
//	@Override
//	public Bookings findByBookingName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Bookings findByBookingName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createBooking(BookingDto bookingDto) {
		
		Long userId = bookingDto.getUserId();
		User user = userRepository.findById(userId).orElseThrow();
		ModelMapper maper = new ModelMapper();
		Bookings booking = maper.map(bookingDto, Bookings.class);
		booking.getHotelList().clear();
		booking.getCateringList().clear();
		List<Hotel> hotelList = new ArrayList<>();
		List<Catering> cateringList = new ArrayList<>();
		bookingDto.getHotel().forEach(h->hotelList.add(hotelRepository.findById(h).orElseThrow()));
		bookingDto.getCatering().forEach(c->cateringList.add(cateringRepository.findById(c).orElseThrow()));
		
		
		for( Hotel hotel : hotelList)
		{
			booking.addHotel(hotel);
		}
		
		for(Catering catering : cateringList)
		{
			booking.addCatering(catering);
		}
		
		booking.setUser(user);
		bookingRepository.save(booking);
		
		
		return "Booking Successfully...!";
	}
	
}
