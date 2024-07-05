package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToMany;

import com.app.entities.Bookings;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CateringDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	
	private String caterName;

	
	private String cater_desc;

	
	private String cater_location;

	
	private double cater_price;

	
	private String cater_img;
	



}
