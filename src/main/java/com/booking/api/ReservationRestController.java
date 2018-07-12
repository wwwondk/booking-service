package com.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.config.AuthUser;
import com.booking.dto.ReservationDto;
import com.booking.dto.User;
import com.booking.service.ReservationService;

@RestController
@RequestMapping("/appointments")
public class ReservationRestController {
	private ReservationService reservationService;
	
	@Autowired
	public ReservationRestController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@PostMapping
	public int insertReservation(@RequestBody ReservationDto reservationDto, @AuthUser User user){
		reservationDto.setUserId(user.getId());
		try{
			int rid = reservationService.insertReservation(reservationDto);
			return rid;
		}catch(Exception e){
			System.out.println("ERROR!");
			return 0;
		}
		
	}
	
	@DeleteMapping("/{id}")
	public int deleteReservation(@PathVariable int id){
		return reservationService.deleteReservation(id);
	}
}
