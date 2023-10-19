package com.revature.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class CardUtils {

    // Generates a 15-digit number and appends the luhn digit.
    public int generateCardNumber() {
        Random random = new Random();

        StringBuilder ccNum = new StringBuilder(15);

        for (int i = 0; i < ccNum.capacity() - 1; i++) {
            int digit = random.nextInt(10);
            ccNum.append(digit);
        }

        int sum = 0;
        boolean doubleDigit = false;
        for (int i = 14; i >= 0; i--) {
            int digit = Integer.parseInt(ccNum.substring(i, i + 1));

            if (doubleDigit) {
                digit *= 2;

                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        int checkDigit = (10 - (sum % 10)) % 10;

        ccNum.append(checkDigit);

        return Integer.valueOf(ccNum.toString());
    }

    public short generateExpDate() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate updatedDate = localDate.plusYears(5);

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MMyy");

        return Short.valueOf(updatedDate.format(formatDate));
    }

    public int generateCvv(long ccNum, short expDate) {
        String dataToHash = String.valueOf(ccNum) + String.valueOf(expDate);

        byte[] hash = new byte[0];

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(dataToHash.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return Integer.valueOf(((hash[0] & 0xFF) * 100 + (hash[1] & 0xFF) * 100 + (hash[2] & 0xFF)) % 1000);
    }
}
