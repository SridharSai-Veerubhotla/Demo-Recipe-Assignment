package com.hotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.exception.UserException;
import com.hotel.pojo.User;
import com.hotel.repository.UserRepository;
import com.hotel.util.UserUtility;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;

	public User createUser(User user) {

		Optional<User> retrivedUser = repository.findByUserName(user.getUserName());
		if (retrivedUser.isEmpty()) {
			UserUtility utility = new UserUtility();
			utility.validateUser(user);
			user.setUserRole(2);
			User savedUser = repository.save(user);
			return savedUser;
		} else {
			throw new UserException("User already exists.");
		}
	}

	
	

}
