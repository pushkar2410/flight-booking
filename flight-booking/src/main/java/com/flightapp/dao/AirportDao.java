package com.flightapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, String>{

}
