package com.lab.problemaday.lcEasy;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static int reverse(int x) {

        long val = 0;
        do {
            int r = x % 10;
            val = val * 10 + r;
            if (val != (int) val) return 0; //checking for overflow, logic borrowed from Math.exactMultiply()
            x = x / 10;
        } while (x != 0);

        return (int) val;
    }

}
