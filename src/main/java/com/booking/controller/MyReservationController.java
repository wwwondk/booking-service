package com.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.config.AuthUser;
import com.booking.dto.User;
import com.booking.service.MyReservationService;

@Controller
@RequestMapping("/my-reservation")
public class MyReservationController {

	private MyReservationService myReservationService;
	
	public MyReservationController(MyReservationService myReservationService) {
		this.myReservationService = myReservationService;
	}
	
	@GetMapping
	public String myReservation(Model model, @AuthUser User user){
		int userId = user.getId();
		model.addAttribute("reservationList", myReservationService.selectAll(userId));
		model.addAttribute("summary", myReservationService.selectReservationTypeCount(userId));
		return "myreservation";
	}
}
