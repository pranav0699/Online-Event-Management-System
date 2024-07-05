package com.app.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingDto;
import com.app.entities.Bookings;
import com.app.entities.Catering;
import com.app.entities.Hotel;
import com.app.entities.User;
import com.app.services.BookingService;
import com.app.services.CateringService;
import com.app.services.HotelService;
import com.app.services.UserService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
    private BookingService bookingService;
	
	
	@PostMapping("/createBooking")
	public ResponseEntity<?> createBooking(@RequestBody BookingDto bookingDto)
	{
		return ResponseEntity.ok(bookingService.createBooking(bookingDto));
		
	}
	
	
	

//	@PostMapping("/bookings")
//    public ResponseEntity<Bookings> createBooking(@RequestBody Bookings booking) {
//        try {
//            // Extract hotel names
//            List<String> hotelNames = new ArrayList<>();
//            for (Hotel hotel : booking.getHotelList()) {
//                hotelNames.add(hotel.getHotelName());
//            }
//
//            
//            List<String> cateringNames = new ArrayList<>();
//            for (Catering catering : booking.getCateringList()) {
//                cateringNames.add(catering.getCaterName());
//            }
//        
//
//       
//          Bookings createdBooking = bookingService.createBooking(booking.getUser().getId(), hotelNames, cateringNames,
//                    booking.getPhotographer(), booking.getMakeupartist());
//
//            return ResponseEntity.ok(createdBooking);
//        } catch (IllegalArgumentException e) {
//            
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//   
//          
//	}
	}



   



