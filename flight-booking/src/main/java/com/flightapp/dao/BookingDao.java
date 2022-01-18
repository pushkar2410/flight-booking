package com.flightapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, Integer> {

}
