package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity{
	
	@Column()
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column()
	private String email;
	
	@Column()
	private String password;
	
	@Column
	private String contactNo;

	@Column
	@Enumerated(EnumType.STRING)
	private Role role;
	

}
