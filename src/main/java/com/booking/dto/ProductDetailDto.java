package com.booking.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

public @Data class ProductDetailDto {
	private int id;
    private String name;
    private String description;
    private int salesFlag;
    private String event;
    private String content;
    private String observationTime;
    private Timestamp displayStart;
    private Timestamp displayEnd;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;
    private float avgScore;
    private int reviewCount;
    private List<Integer> bannerImageIdList;
    private List<CommentDetailDto> comments;
    private List<Integer> noticeImageIdList;
    private int descriptionImageId;
}
