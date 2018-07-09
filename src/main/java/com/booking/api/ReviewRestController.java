package com.booking.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.booking.config.AuthUser;
import com.booking.dto.User;
import com.booking.service.ReviewService;

@RestController
public class ReviewRestController {
	
	private ReviewService reviewService;
	
	@Autowired
	public ReviewRestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping("/comments")
	public void insertReview(@RequestParam int starPoint, @RequestParam String comment,	@RequestParam int productId, @RequestParam int reservationId,
			@RequestParam MultipartFile[] reviewFile, HttpServletRequest request, @AuthUser User user) {

		int userId = user.getId();
		reviewService.insertReview(starPoint, comment, reviewFile, request, userId, productId, reservationId);
		
	}
	
}
