package com.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.config.AuthUser;
import com.booking.dto.ReservationDto;
import com.booking.dto.User;
import com.booking.service.ReservationService;

@RestController
@RequestMapping("/api/booking")
public class ReservationRestController {
	private ReservationService reservationService;
	
	@Autowired
	public ReservationRestController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@PostMapping
	public void insertReservation(@RequestAttribute ReservationDto reservationDto, @AuthUser User user){
		reservationDto.setUserId(user.getId());
		int rid = reservationService.insertReservation(reservationDto);
		System.out.println(rid);
	}
}
