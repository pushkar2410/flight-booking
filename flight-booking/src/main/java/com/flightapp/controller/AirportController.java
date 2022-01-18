package com.flightapp.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.Airport;
import com.flightapp.service.AirportService;

@RestController
@RequestMapping("/api/v1.0/flight/")
public class AirportController {

	private AirportService airportService;

	public AirportController(AirportService airportService) {
		this.airportService = airportService;
	}

	@GetMapping("getAllAirport")
	public ResponseEntity<Iterable<Airport>> getAllAirport() {
		return ResponseEntity.status(HttpStatus.OK).body(airportService.viewAllAirport());
	}

	@GetMapping("getAirport/{airportCode}")
	public ResponseEntity<Airport> getAirport(@PathVariable("airportCode")  String airportCode){
		Airport airport = airportService.viewAirport(airportCode);
		return ResponseEntity.ok(airport);
	}
	
	@PostMapping("")
	public ResponseEntity<?> newAirport(@RequestBody Airport airport){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(airportService.createAirport(airport));
	}
	
	@PutMapping("updateAirport/{airportCode}")
	public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport,
			@PathVariable("airportCode") String airportCode) {
		
		return ResponseEntity.status(HttpStatus.OK).body(airportService.updateAirport(airport, airportCode));
	}
	
	@DeleteMapping("deleteAirport/{airportCode}")
	public ResponseEntity<?> deleteAirport(@PathVariable("airportCode") String airportCode) {
		airportService.deleteAirport(airportCode);
		return ResponseEntity.status(HttpStatus.OK).build();
	}


	
	
}
