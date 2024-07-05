package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Catering;

@Repository
public interface CateringRepo extends JpaRepository<Catering, Long> {
	
	//Catering findByCaterName(String caterName);

	//List<Catering> findByCaterName(List<String> cateringName);
	//List<Catering> findByCaterName(List<String> cateringNames);
	List<Catering> findByCaterName(String caterName);

}
