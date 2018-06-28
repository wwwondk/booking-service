package com.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.booking.service.MyReservationService;

@Controller
public class MyReservationController {

	private MyReservationService myReservationService;
	
	public MyReservationController(MyReservationService myReservationService) {
		this.myReservationService = myReservationService;
	}
	
	@GetMapping("/my-reservation")
	public String myReservation(Model model){
		int userId = 10;
		model.addAttribute("reservationList", myReservationService.selectAll(userId));
		model.addAttribute("summary", myReservationService.selectReservationTypeCount(userId));
		return "myreservation";
	}
}
