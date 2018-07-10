package com.booking.dto;

import java.util.Date;

import lombok.Data;

public @Data class ReservationDto {
	private int id;
	private int productId;
	private int userId;
	private int generalTicketCount;
	private int youthTicketCount;
	private int childTicketCount;
	private String reservtionName;
	private String reservationTel;
	private String reservationEmail;
	private String reservationDate;
	private String reservationType;
	private Date createDate;
	private Date modifyDate;
	private int totalPrice;
}
