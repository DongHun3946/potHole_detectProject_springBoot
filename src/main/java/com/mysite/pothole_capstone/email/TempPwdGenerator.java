package com.mysite.pothole_capstone.email;

import java.security.SecureRandom;

public class TempPwdGenerator { //임시 비밀번호 생성 클래스
    private static final String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int pwd_length = 10;

    public static String generateTempPasswd() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(pwd_length);
        for (int i = 0; i < pwd_length; i++) {
            int index = random.nextInt(CHAR.length());
            sb.append(CHAR.charAt(index));
        }
        return sb.toString();
    }
}
