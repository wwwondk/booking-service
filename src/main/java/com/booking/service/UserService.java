package com.booking.service;

import com.booking.dto.User;

public interface UserService {
	public User selectByEmail(String email);
	public User create(User user);
	public User update(User user);
}
