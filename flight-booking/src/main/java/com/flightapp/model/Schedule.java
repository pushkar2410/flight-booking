package com.flightapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Schedule {
	@Id
	@GeneratedValue
	private Integer scheduleId;
	@OneToOne
	private Airport srcAirport;
	@OneToOne
	private Airport destAirport;
	private String deptDateTime;
	private String arrDateTime;
}
