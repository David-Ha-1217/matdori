package com.estsoft13.matdori.util;

import java.security.SecureRandom;

public class GeneratePassword {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    // 비밀번호 생성
    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        return password.toString();
    }
}
