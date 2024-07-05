package com.app.entities;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "catering")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Catering extends BaseEntity {

	@Column
	private String caterName;

	@Column
	private String cater_desc;

	@Column
	private String cater_location;

	@Column
	private double cater_price;

	@Column
	private String cater_img;
	
	@ManyToMany(mappedBy = "cateringList")
	private List<Bookings> bookings = new ArrayList<>();

//	@ManyToOne
//	@JoinColumn
//	private Bookings booking;

}
