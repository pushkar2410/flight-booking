package com.flightapp.model;

import javax.persistence.Entity;
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
public class Flight {
	@Id
	private Integer flightNo;
	private String carrierName;
	private String flightModel;
	private Integer seatCapacity;
}
