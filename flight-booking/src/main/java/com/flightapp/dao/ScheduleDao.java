package com.flightapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.Schedule;

@Repository
public interface ScheduleDao extends CrudRepository<Schedule, Integer> {

}
