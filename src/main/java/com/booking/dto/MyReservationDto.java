package com.booking.dto;

import lombok.Data;

public @Data class MyReservationDto {
	private String id;
	private String productId;
	private int generalTicketCount;
	private int youthTicketCount;
	private int childTicketCount;
	private String reservationDate;
	private String reservationType;
	private int totalPrice;
	private String productName;
}
