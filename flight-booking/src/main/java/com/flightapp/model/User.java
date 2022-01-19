package com.flightapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userEmail;
	
	
}
