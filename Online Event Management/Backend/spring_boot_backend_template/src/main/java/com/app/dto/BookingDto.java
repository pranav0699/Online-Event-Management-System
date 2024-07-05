package com.app.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.app.entities.Catering;
import com.app.entities.Hotel;
import com.app.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	private Date event_date;
	
	
	private String max_total_hour;
	
	
	private double amount;
	
	
	private String no_of_guest;
	
	
	private Boolean photographer_name_desc=false;
	
	
	private Boolean makeupartist_name_desc=false;

	
	private Boolean payment_status=false;
	
	private List<Long> hotel = new ArrayList();

	private List<Long> catering = new ArrayList();
	
	private Long userId;



}
