package com.app.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HotelDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	

	private String hotelName;
    
 
	private String hotelDesc;
    

	private String hotelImg1;

 
    private int price;
    

    private String location;
    
    


}
