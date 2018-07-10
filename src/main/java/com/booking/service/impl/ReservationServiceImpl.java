package com.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.ReservationDao;
import com.booking.dto.ReservationDto;
import com.booking.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	private ReservationDao reservationDao;
	
	@Autowired
	public ReservationServiceImpl(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}
	
	@Override
	public int insertReservation(ReservationDto reservationDto) {
		reservationDao.insertReservation(reservationDto);
		return reservationDto.getId();
	}
	
}
