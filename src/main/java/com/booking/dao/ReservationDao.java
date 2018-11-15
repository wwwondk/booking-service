package com.booking.dao;

import org.springframework.stereotype.Repository;

import com.booking.dto.ReservationDto;

@Repository
public interface ReservationDao {
	public int insertReservation(ReservationDto reservationDto);
	public int deleteReservation(int reservationId);
}
