package com.revature.personalcard.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class CardUtils {

    // Generates a 16-digit card number (15-digits + 1 Luhn algorithm check digit)
    public int generateCardNumber() {
        Random random = new Random();

        // Generates the first 15 characters of a card number
        StringBuilder ccNum = new StringBuilder(15);

        for (int i = 0; i < ccNum.capacity() - 1; i++) {
            int digit = random.nextInt(10);
            ccNum.append(digit);
        }

        // Calculate the Luhn digit
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

        // Append the luhn check digit to the credit card number.
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

    public int generateCVV(long ccNum, short expDate) {
        String dataToHash = String.valueOf(ccNum) + String.valueOf(expDate);

        byte[] hash = new byte[0];

        try {
            // Create a encryption digest.
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Compute the hash.
            hash = digest.digest(dataToHash.getBytes());


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        /* Explanation of this return statement: This is the generated CVV.
           What is occurring here is that we are truncating the SHA256-hashed appended result of the
           credit card number and expiry date to the first 3 value indices, and then
           ANDing each by HEX 0xFF. Once the AND operation is completed, each extracted byte then gets
           multiplied by 100. This shifts the value of each to the hundredths place.

           They are then added together, with the result of which being set to 3 digits through a MOD 100.

           The returned result is a 3-digit short which simulates a CVV code. Note that this is a simplified
           form of how to perform this, and it would be likely more complex than this in the fintech space.
         */

        return Integer.valueOf(((hash[0] & 0xFF) * 100 + (hash[1] & 0xFF) * 10 + (hash[2] & 0xFF)) % 1000);
    }
}