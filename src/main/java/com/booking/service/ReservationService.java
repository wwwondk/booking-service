package com.booking.service;

import com.booking.dto.ReservationDto;

public interface ReservationService {
	public int insertReservation(ReservationDto reservationDto);
	public int deleteReservation(int reservationId);
}
