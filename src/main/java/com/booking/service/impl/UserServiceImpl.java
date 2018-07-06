package com.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.UserDao;
import com.booking.dto.User;
import com.booking.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User selectByEmail(String email) {
		return userDao.selectByEmail(email);
	}

	@Override
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}
	
}
