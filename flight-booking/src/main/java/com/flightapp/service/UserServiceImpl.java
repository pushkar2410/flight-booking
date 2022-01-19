package com.flightapp.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.dao.UserDao;
import com.flightapp.exception.RecordNotFoundException;
import com.flightapp.model.User;

@Service
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public Iterable<User> allUsers() {
		return userDao.findAll();
	}

	@Override
	public ResponseEntity<?> createUser(User user) {
		user.setUserId(new Random().nextInt(99999));
		userDao.save(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@Override
	public User updateUser(User user, Integer userId) {
		Optional<User> byId = userDao.findById(userId);
		if(byId.isPresent()) {
			User user2 = byId.get();
			user2.setUserName(user.getUserName());
			user2.setUserPassword(user.getUserPassword());
			user2.setUserPhone(user.getUserEmail());
			user2.setUserEmail(user.getUserEmail());
			userDao.save(user2);
		}else {
			throw new RecordNotFoundException("User with ID : " + user.getUserId() + " is not present");
		}
		return user;
	}

	@Override
	public User findUserById(Integer userId) {
		Optional<User> byId = userDao.findById(userId);

		if (byId.isPresent()) {
			return byId.get();
		} else {
			throw new RecordNotFoundException("User with user Id : " + userId + "not found");
		}
	}

	@Override
	public void deleteUser(Integer userId) {
		Optional<User> byId = userDao.findById(userId);

		if (byId.isPresent()) {
			userDao.deleteById(userId);
		} else {
			throw new RecordNotFoundException("User with user Id : " + userId + "not found");
		}
	}

}
