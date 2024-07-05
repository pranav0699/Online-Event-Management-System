package com.app.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity()
@Table(name="bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bookings extends BaseEntity {
	
	@Column
	private Date event_date;
	
	@Column(length = 10)
	private String max_total_hour;
	
	@Column
	private double amount;
	
	@Column
	private String no_of_guest;
	
	@Column
	private Boolean photographer=false;
	
	@Column
	private Boolean makeupartist=false;

	@Column
	private Boolean payment_status=false;
	
//	@OneToMany(mappedBy = "booking"	)	
//	private List<Hotel> hotel;
//	
//
//	@OneToMany(mappedBy = "booking")
//	private List<Catering> catering;
	
	@ManyToOne()
	@JoinColumn(name="user_id",nullable = false)
	private User user;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="bookings_hotel", joinColumns = @JoinColumn(name="booking_id"),
	inverseJoinColumns = @JoinColumn(name="hotel_id"))
	private List<Hotel> hotelList = new ArrayList<>();

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="bookings_catering", joinColumns = @JoinColumn(name="booking_id"),
	inverseJoinColumns = @JoinColumn(name="catering_id"))
	private List<Catering> cateringList = new ArrayList<>();
	
	public void addHotel(Hotel hotel)
	{
		this.hotelList.add(hotel);
		hotel.getBookings().add(this);
		
	}
	
	public void addCatering(Catering catering)
	{
		this.cateringList.add(catering);
		catering.getBookings().add(this);
		
	}
	

	
	
//	@ManyToOne
//	@JoinColumn(name = "hotel_id") 
//	private Hotel hotel;

//	
//	@OneToOne(mappedBy = "booking")
//    private Hotel hotels;
//	
//	@OneToMany(mappedBy = "booking")
//	private Hotel hotels; // Change the type to Hotel
//
//	public void setHotel(Hotel hotel) {
//	    this.hotel = hotel;
	}

