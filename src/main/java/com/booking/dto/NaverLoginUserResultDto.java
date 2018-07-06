package com.booking.dto;

import lombok.Data;

public @Data class NaverLoginUserResultDto {
	private String message;
	private NaverLoginUserDto response;
}
