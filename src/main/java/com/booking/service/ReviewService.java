package com.booking.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.booking.dto.ReviewDetailDto;
import com.booking.dto.ReviewDto;

public interface ReviewService {
	public List<ReviewDto> selectProductReviewList(int productId, int page, int limits);
	public ReviewDetailDto selectReviewAvgCount(int productId);
	public void insertReview(int starPoint, String comment, MultipartFile[] reviewFile, HttpServletRequest request, int userId, int productId, int reservationId);
	
}
