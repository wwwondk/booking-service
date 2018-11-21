package com.booking.service;

import java.util.List;
import java.util.Map;

import com.booking.dto.MyReservationDto;

public interface MyReservationService {
	public List<MyReservationDto> selectAll(int userId);
	public Map<String, Integer> selectReservationTypeCount(int userId);
	public void reservationRefundCancel(int reservationId);
}
