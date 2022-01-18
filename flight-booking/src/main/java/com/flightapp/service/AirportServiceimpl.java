package com.flightapp.service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.dao.AirportDao;
import com.flightapp.exception.RecordAlreadyPresentException;
import com.flightapp.exception.RecordNotFoundException;
import com.flightapp.model.Airport;

@Service
public class AirportServiceimpl implements AirportService {

	private AirportDao airportDao;

	@Autowired
	public AirportServiceimpl(AirportDao airportDao) {
		this.airportDao = airportDao;
	}

	@Override
	public Iterable<Airport> viewAllAirport() {
		return airportDao.findAll();
	}

	@Override
	public Airport viewAirport(String airportCode) {
		Optional<Airport> byId = airportDao.findById(airportCode);

		if (byId.isPresent()) {
			return byId.get();
		} else {
			throw new RecordNotFoundException("Airport with airport code: " + airportCode + "not exists");
		}
	}

	@Override
	public ResponseEntity<?> createAirport(Airport airport) {
		airport.setAirportCode(String.format("%05d",new Random().nextInt(99999)));
		Optional<Airport> id = airportDao.findById(airport.getAirportCode());

		if (!id.isPresent()) {
			airportDao.save(airport);
			return new ResponseEntity<Airport>(airport, HttpStatus.OK);
		} else {
			throw new RecordAlreadyPresentException(
					"Airport with code : " + airport.getAirportCode() + " is already avaialbe");
		}
	}
	
	@Override
	public Airport updateAirport(Airport airport, String airportCode ) {

		Optional<Airport> findById = airportDao.findById(airportCode);
		if (findById.isPresent()) {
			airportDao.save(airport);
		} else
			throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " is not exists");
		return airport;
	}

	@Override
	public String deleteAirport(String airportCode) {

		Optional<Airport> findById = airportDao.findById(airportCode);
		if (findById.isPresent()) {
			airportDao.deleteById(airportCode);
			return "Airport removed";
		} else
			throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

	}
}
