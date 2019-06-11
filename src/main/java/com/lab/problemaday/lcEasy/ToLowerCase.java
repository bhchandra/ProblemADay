package com.lab.problemaday.lcEasy;

public class ToLowerCase {

    //The solution assumes we are only dealing with english letters in the range A-Z

    //real world scenarios consists of different encoding, languages, character sets, and locales,
    //and the correct solution is to use `str.toLowerCase()`.
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= (int) 'A' && chars[i] <= (int) 'Z') {
                chars[i] = (char) (chars[i] + ('a' - 'A'));
            }
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args) {

        System.out.println(
                toLowerCase("Hello")
        );

        System.out.println(
                toLowerCase("MAMA MIA!")
        );

    }


}
