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
@Table(name="hotel")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Hotel extends BaseEntity{
	
	
    @Column
	private String hotelName;
    
    @Column
	private String hotelDesc;
    
    @Column
	private String hotelImg1;

    @Column
    private int price;
    
    @Column
    private String location;
    
    
    @ManyToMany(mappedBy = "hotelList")
    private List<Bookings> bookings= new ArrayList<>();
    
//  @ManyToOne
//	@JoinColumn()
//	private Bookings booking;

    

}
