package com.flightapp.service;

import org.springframework.http.ResponseEntity;

import com.flightapp.model.Airport;

public interface AirportService {
	
	public Iterable<Airport> viewAllAirport();
	
	public Airport viewAirport(String airportCode);

	public ResponseEntity<?> createAirport(Airport airport);

	public Airport updateAirport(Airport airport, String airportCode);

	public String deleteAirport(String airportCode);
}
