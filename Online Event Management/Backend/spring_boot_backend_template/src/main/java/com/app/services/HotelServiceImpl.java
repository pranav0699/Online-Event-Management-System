package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.HotelDto;
import com.app.entities.Hotel;
import com.app.entities.User;
import com.app.repository.HotelRepo;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel findById(Long hotelId) {
		
		return hotelRepo.findById(hotelId).orElseThrow();
	}

	@Override
	public Hotel findByName(String hotelName) {
		
		return hotelRepo.findByhotelName(hotelName);
	}

	@Override
	public String hotelUpdate(Hotel hotel) {
		
		Hotel h = hotelRepo.findById(hotel.getId()).orElseThrow();
		ModelMapper maper = new ModelMapper();
		maper.map(maper, h);
		return "Hotel Updated";
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		
		return null;
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return hotelRepo.findAll();
	}

	@Override
	public Hotel addHotel(HotelDto hotel) {
		
		ModelMapper maper = new ModelMapper();
		
	Hotel hotell = 	maper.map(hotel, Hotel.class);
		
		return hotelRepo.save(hotell);
		
	}
//
//	@Override
//	public void updateHotel(String hotelName, Hotel updatedHotel) {
//		Hotel hotel = hotelRepo.findByhotelName(hotelName);
//        if (hotel != null) {
//            hotel.setHotelDesc(updatedHotel.getHotelDesc());
//            hotel.setHotelImg1(updatedHotel.getHotelImg1());
//            hotel.setPrice(updatedHotel.getPrice());
//            hotel.setLocation(updatedHotel.getLocation());
//            hotelRepo.save(hotel);
//        } else {
//            throw new IllegalArgumentException("Hotel not found with name: " + hotelName);
//        }
//		
//	}

	@Override
	public void updateHotel(String hotelName, Hotel updatedHotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String updateHotel(Hotel hotel) {
		Hotel u = hotelRepo.findById(hotel.getId()).orElseThrow();
		ModelMapper maper = new ModelMapper();
		maper.map(hotel, u);
		
		return "Hotel Updated";
	}
	
	

}
