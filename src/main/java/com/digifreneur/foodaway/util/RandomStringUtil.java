package com.digifreneur.foodaway.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomStringUtil {
    // function to generate a random string of length n
    public static String getAlphaNumericString(int n, String inputString) throws NoSuchAlgorithmException {

        // chose a Character random from this String
        String inputStringUcase = inputString.trim().toUpperCase().replace(" ", "").concat("123456789");

        // create StringBuffer size of inputString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to inputString variable length
            Random rand = SecureRandom.getInstanceStrong();
            int index = inputStringUcase.length() * rand.nextInt();

            // add Character one by one in end of sb
            sb.append(inputStringUcase.charAt(index));
        }

        return sb.toString();
    }
}