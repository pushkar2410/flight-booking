package com.flightapp.service;

import org.springframework.http.ResponseEntity;

import com.flightapp.model.User;

public interface UserService {
	
	public ResponseEntity<?> createUser(User user);
	
	public User updateUser(User user, Integer userId);
	
	public Iterable<User> allUsers();

	public User findUserById(Integer userId);
	
	public void deleteUser(Integer userId);
}
