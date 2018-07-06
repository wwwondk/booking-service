package com.booking.dto;

import java.util.Date;

import lombok.Data;

public @Data class UserDto {
    private int id;
    private String username;
    private String email;
    private String tel;
    private String nickname;
    private String snsId;
    private String snsType;
    private String snsProfile;
    private int adminFlag;
    private Date createDate;
    private Date modifyDate;
}
