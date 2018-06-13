package com.booking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.booking.dto.CategoryDto;

@Repository
public interface ReviewDao {
	public String selectName(int reservationId);
}
