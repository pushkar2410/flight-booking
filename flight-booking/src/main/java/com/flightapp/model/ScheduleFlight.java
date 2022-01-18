package com.flightapp.model;

import javax.persistence.Entity;
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
public class ScheduleFlight {
	@Id
	private Integer scheduleFlightId;
	@OneToOne
	private Flight flight;
	private Integer availableSeats;
	@OneToOne
	private Schedule schedule;
}
