package com.app.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class getAllCateringDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	private String caterName;

	
	private String cater_desc;

	
	private String cater_location;

	
	private double cater_price;


	private String cater_img;

}
