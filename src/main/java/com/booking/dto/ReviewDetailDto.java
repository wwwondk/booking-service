package com.booking.dto;

import java.util.List;

import lombok.Data;

public @Data class ReviewDetailDto {
	private int productId;
	private float avgScore;
	private int reviewCount;
	private String name;
	private List<ReviewDto> reviews;
}
