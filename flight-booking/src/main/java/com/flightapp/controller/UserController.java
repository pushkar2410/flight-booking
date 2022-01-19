package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.flightapp.model.User;
import com.flightapp.service.UserService;

@RestController
@RequestMapping("/api/v1.0/flight/")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("allUsers")
	public ResponseEntity<Iterable<User>> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.allUsers());
	}

	@GetMapping("user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(userId));
	}

	@PostMapping("newuser")
	public ResponseEntity<?> newUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}

	@PutMapping("update/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user, userId));
	}

	@DeleteMapping("delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
