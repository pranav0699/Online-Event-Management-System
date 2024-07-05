package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dto.CateringDto;
import com.app.dto.getAllCateringDto;
import com.app.entities.Catering;
import com.app.entities.Hotel;
import com.app.repository.CateringRepo;

@Service
@Transactional
public class CateringServiceImpl implements CateringService {
	
	@Autowired
	CateringRepo cateringRepo;

	@Override
	public Catering findById(Long id) {
		
		return cateringRepo.findById(id).orElseThrow();
	}

//	@Override
//	public Catering findByName(String name) {
//		
//		return cateringRepo.findByCaterName(name);
//	}

	@Override
	public String updateCatering(Catering catering) {
		
		Catering c = cateringRepo.findById(catering.getId()).orElseThrow();
		ModelMapper maper = new ModelMapper();
		maper.map(maper, c);
		
		return"Catering updated";
	}

	@Override
	public Catering addCatering(Catering catering) {
		return cateringRepo.save(catering);
	}

	@Override
	public List<Catering> getAllCatering() {
		
		return cateringRepo.findAll();
	}

	@Override
	public Catering findByName(String name) {
		
		return null;//cateringRepo.findByCaterName(name);
	}

	@Override
	public Catering addCatering(CateringDto catering) {
		ModelMapper maper = new ModelMapper();
		
		Catering cat = 	maper.map(catering, Catering.class);
			
			return cateringRepo.save(cat);
	}
	
	

}
