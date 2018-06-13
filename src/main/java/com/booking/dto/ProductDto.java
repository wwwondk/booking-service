package com.booking.dto;

import lombok.Data;

public @Data class ProductDto {
	private int productId;
	private String productName;
	private String productDescription;
	private String placeName;
	private int fileId;
	private String fileName;
	private String saveFileName;
}
