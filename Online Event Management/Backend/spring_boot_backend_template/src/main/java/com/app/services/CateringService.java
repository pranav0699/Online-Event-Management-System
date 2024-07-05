package com.app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.CateringDto;
import com.app.dto.HotelDto;
import com.app.dto.getAllCateringDto;
import com.app.entities.Catering;
import com.app.entities.Hotel;

public interface CateringService {
	
	Catering findById(Long id);
	 
	Catering findByName(String name);
	
	String updateCatering(Catering catering);
	
	Catering addCatering(Catering catering);
	
	List<Catering> getAllCatering();
	
	Catering addCatering(CateringDto catering);

}
