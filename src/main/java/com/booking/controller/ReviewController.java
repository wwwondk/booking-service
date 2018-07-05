package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.dto.ReviewDetailDto;
import com.booking.service.ReviewService;

@Controller
public class ReviewController {
	
	private ReviewService reviewService;
	
	@Autowired
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/reviews")
	public String reviews(Model model, @RequestParam("pid") int productId){
		ReviewDetailDto reviewDetailDto = reviewService.selectReviewAvgCount(productId);
		reviewDetailDto.setReviews(reviewService.selectProductReviewList(productId, 0, 10));
		model.addAttribute("comments", reviewDetailDto);
		return "review";
	}
	
	@GetMapping("/reviews/write")
	public String reviewWrite(Model model, @RequestParam("rid") int reservationId, @RequestParam("pid") int productId, @RequestParam("pname") String productName){
		int userId = 10;
		model.addAttribute("reservationId", reservationId);
		model.addAttribute("productId", productId);
		model.addAttribute("productName", productName);
		return "reviewWrite";
	}
}
