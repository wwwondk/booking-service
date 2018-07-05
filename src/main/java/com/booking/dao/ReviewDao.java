package com.booking.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.booking.dto.ReviewDetailDto;
import com.booking.dto.ReviewDto;
import com.booking.dto.ReviewWriteDto;

@Repository
public interface ReviewDao {
	public String selectName(int reservationId);
	public List<ReviewDto> selectProductReviewList(Map<String, Object> param);
	public ReviewDetailDto selectReviewAvgCount(int productId);
	public Integer insertReview(ReviewWriteDto reviewWriteDto);
	public Integer insertReviewImage(Map<String, Object> param);
}
