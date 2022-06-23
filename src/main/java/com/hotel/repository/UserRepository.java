package com.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User save(User user);
	Optional<User> findByUserName(String userName);

}
