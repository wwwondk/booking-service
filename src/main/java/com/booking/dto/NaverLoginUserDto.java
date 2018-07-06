package com.booking.dto;

import lombok.Data;

public @Data class NaverLoginUserDto {
    private String email;
    private String nickname;
    private String profile_image;
    private String age;
    private String gender;
    private String id;
    private String birthday;
    
    public UserDto convertToUser() {
        UserDto user = new UserDto();
        user.setAdminFlag(0);
        user.setUsername(this.getEmail().split("@")[0]);
        user.setEmail(this.getEmail());
        user.setNickname(this.getNickname());
        user.setSnsId(this.getId());
        user.setSnsProfile(this.getProfile_image());
        return user;
    }
}
