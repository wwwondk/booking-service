package com.booking.dto;

import lombok.Data;

public @Data class ProductPriceDto {
	private int productId;
	private int priceType;
	private int price;
	private double discountRate;
}
