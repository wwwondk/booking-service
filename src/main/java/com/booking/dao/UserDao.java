package com.booking.dao;

import org.springframework.stereotype.Repository;

import com.booking.dto.User;

@Repository
public interface UserDao {
	public User selectByEmail(String email);
	public Integer create(User user);
	public Integer update(User user);
}
