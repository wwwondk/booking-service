package com.booking.dto;

import java.sql.Timestamp;

import lombok.Data;

public @Data class CommentDetailDto {
    private int id;
    private String comment;
    private float score;
    private String nickname;
    private Timestamp createDate;
    private int thumbnailFileId;
    private int thumbnailCount;

}
