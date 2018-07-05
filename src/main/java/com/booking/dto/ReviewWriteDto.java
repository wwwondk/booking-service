package com.booking.dto;

import java.util.Date;

import lombok.Data;

public @Data class ReviewWriteDto {
	private int id;
	private int productId;
	private int userId;
	private float score;
	private String comment;
	private Date createDate;
	private Date modifyDate;
}
