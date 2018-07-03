package com.booking.service;

import java.util.List;

import com.booking.dto.ReviewDetailDto;
import com.booking.dto.ReviewDto;

public interface ReviewService {
	public List<ReviewDto> selectProductReviewList(int productId, int page, int limits);
	public ReviewDetailDto selectReviewAvgCount(int productId);
	
}
