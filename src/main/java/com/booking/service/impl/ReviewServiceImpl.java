package com.booking.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.ReviewDao;
import com.booking.dto.ReviewDetailDto;
import com.booking.dto.ReviewDto;
import com.booking.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewDao reviewDao;
	
	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public List<ReviewDto> selectProductReviewList(int productId, int page, int limit) {
		Map<String, Object> param = new HashMap<>();
		param.put("productId", productId);
		param.put("page", page);
		param.put("limit", 3);
		return reviewDao.selectProductReviewList(param);
	}

	@Override
	public ReviewDetailDto selectReviewAvgCount(int productId) {
		return reviewDao.selectReviewAvgCount(productId);
	}

}
