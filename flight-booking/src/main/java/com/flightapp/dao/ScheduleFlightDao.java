package com.flightapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.ScheduleFlight;

@Repository
public interface ScheduleFlightDao extends CrudRepository<ScheduleFlight, Integer> {

}
