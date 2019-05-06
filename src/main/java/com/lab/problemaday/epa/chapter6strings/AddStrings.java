package com.lab.problemaday.epa.chapter6strings;

public class AddStrings {

    public static void main(String[] args) {
        System.out.println(
                addStrings("99", "9")
        );
    }


    public static String addStrings(String num1, String num2) {

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int length1 = chars1.length;
        int length2 = chars2.length;

        StringBuilder s = new StringBuilder();

        int remainder = 0;
        for (int i = length1 - 1, j = length2 - 1;
             i >= 0 || j >= 0;
             i--, j--) {

            int sum = 0;
            if (i >= 0 && j >= 0) {
                int x = (int) chars1[i] - '0';
                int y = (int) chars2[j] - '0';
                sum = x + y + remainder;
                remainder = sum / 10;
                sum = sum % 10;
            } else if (i >= 0) {
                int x = (int) chars1[i] - '0';
                sum = x + remainder;
                remainder = sum / 10;
                sum = sum % 10;
            } else if (j >= 0) {
                int y = (int) chars2[j] - '0';
                sum = y + remainder;
                remainder = sum / 10;
                sum = sum % 10;
            }
            s.append((char) ('0' + sum));
        }

        if (remainder != 0) {
            s.append((char) ('0' + remainder));
        }

        return s.reverse().toString();
    }
}
