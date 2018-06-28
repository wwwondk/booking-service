package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.service.ProductService;

@Controller
public class ReservationController {

	private ProductService productService;

	@Autowired
	public ReservationController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/reservations")
	public String reservation(Model model, @RequestParam("pid") int productId) {
		model.addAttribute("product", productService.selectProductReservation(productId));
		return "reserve";
	}
}
