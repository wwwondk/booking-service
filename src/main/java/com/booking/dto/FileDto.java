package com.booking.dto;

import java.util.Date;

import lombok.Data;

public @Data class FileDto {
	private int id;
	private int user_id;
	private String fileName;
	private String saveFileName;
	private int fileLength;
	private String contentType;
	private int deleteFlag;
	private Date createDate;
	private Date modifyDate;
}
