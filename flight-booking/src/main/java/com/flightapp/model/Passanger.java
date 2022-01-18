package com.flightapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passanger {
	
	@Id
	@GeneratedValue
	private Integer pnrNumber;
	private String passengerName;
	private String gender;
	private Integer age;
	
}
