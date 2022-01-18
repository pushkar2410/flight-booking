package com.flightapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.Flight;

@Repository
public interface FlightDao extends CrudRepository<Flight, Integer>{

}
