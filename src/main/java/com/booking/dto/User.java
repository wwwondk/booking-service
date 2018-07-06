package com.booking.dto;

import java.util.Date;

import lombok.Data;

public @Data class User {
    public static final String SAME = "Same";
    public static final String NEED_UPDATE = "Need Update";
    
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
    
    public String checkNaverUser(NaverLoginUser naverUser) {
        String checkResult = SAME;
        if (naverUser.getNickname() != null) {
            if (!naverUser.getNickname().equals(this.getNickname())) checkResult = NEED_UPDATE;
        } else {
            if (this.getNickname() != null) checkResult = NEED_UPDATE;
        }
        if (naverUser.getProfile_image() != null) {
            if (!naverUser.getProfile_image().equals(this.getSnsProfile())) checkResult = NEED_UPDATE;
        } else {
            if (this.getSnsProfile() != null) checkResult = NEED_UPDATE;
        }
        return checkResult;
    }
}
