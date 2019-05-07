package com.lab.problemaday.lcEasy;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;


/**
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
 */
public class RomanToInteger {

    private static final Map<Character, Integer> map = init(new HashMap<>());

    public static void main(String[] args) {
        out.println(romanToInt("III"));
        out.println(romanToInt("IV"));
        out.println(romanToInt("IX"));
        out.println(romanToInt("LVIII"));
    }

    private static Map<Character, Integer> init(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException(s);
        }

        //There are six instances where subtraction is used:
        //
        //    I can be placed before V (5) and X (10) to make 4 and 9.
        //    X can be placed before L (50) and C (100) to make 40 and 90.
        //    C can be placed before D (500) and M (1000) to make 400 and 900.


        char[] chars = s.toCharArray();
        int sum = 0;

        for (int i = 0; i < chars.length; i++) {

            if ((i + 1) < chars.length) {
                if (subtractionIsPresent(chars[i], chars[i + 1])) {
                    sum = sum + map.get(chars[i + 1]) - map.get(chars[i]);
                    i++;
                } else {
                    sum = sum + map.get(chars[i]);
                }
            } else {
                sum = sum + map.get(chars[i]);
            }
        }

        return sum;
    }

    private static boolean subtractionIsPresent(char current, char next) {
        return map.get(next) > map.get(current);
    }


}
