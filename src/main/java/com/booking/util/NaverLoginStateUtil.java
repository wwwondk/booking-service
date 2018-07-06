package com.booking.util;

import java.security.*;

import org.springframework.stereotype.*;

@Component
public class NaverLoginStateUtil {
    public String getState() {
        String str = Double.toString(Math.random()) + System.currentTimeMillis();
        String md5;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte item : byteData) {
                sb.append(Integer.toString((item & 0xff) + 0x100, 16).substring(1));
            }
            md5 = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            md5 = null;
        }
        return md5;
    }
}
