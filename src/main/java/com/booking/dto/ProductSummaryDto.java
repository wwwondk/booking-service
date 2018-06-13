package com.booking.dto;

import java.sql.Timestamp;

import lombok.Data;

public @Data class ProductSummaryDto {
	private int id;
	private String name;
	private String observationTime;
	private Timestamp displayStart;
	private Timestamp displayEnd;
	private String placeName;
	private String placeLot;
	private String placeStreet;	
}
