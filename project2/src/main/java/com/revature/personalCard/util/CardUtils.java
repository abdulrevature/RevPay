package com.revature.personalCard.util;

import java.util.Random;

public class CardUtils {

    // Generates a 16-digit card number (15-digits + 1 Luhn algorithm check digit)
    public int generateCardNum() {
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
}