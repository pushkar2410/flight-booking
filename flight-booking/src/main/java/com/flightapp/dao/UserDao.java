package com.flightapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
}
