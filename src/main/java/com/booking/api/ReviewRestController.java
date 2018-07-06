package com.booking.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.booking.service.ReviewService;

@RestController
public class ReviewRestController {
	
	private ReviewService reviewService;
	
	@Autowired
	public ReviewRestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping("/comments")
	public void insertReview(@RequestParam int starPoint, @RequestParam String comment,	
			@RequestParam MultipartFile[] reviewFile, HttpServletRequest request) {
	
		System.out.println("[Controller] starPoint: " + starPoint+ " / comment : " + comment+" / reviewFile : "+reviewFile.length);

		reviewService.insertReview(starPoint, comment, reviewFile, request);
		
	}
	
}
