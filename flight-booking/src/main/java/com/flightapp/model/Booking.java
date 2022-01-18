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
public class Booking {
	@Id
	@GeneratedValue
	private Integer bookingId;
	private String bookingDate;
	private Integer noOfPassengers;
	private String srcLocation;
	private String destLocation;

}
