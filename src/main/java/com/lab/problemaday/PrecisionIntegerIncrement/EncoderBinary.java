package com.lab.problemaday.PrecisionIntegerIncrement;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * Takes two input strings s and t of bits encoding binary numbers Bs & Bt and
 * returns a new String of bits representing the numbers Bs + Bt.
 *
 * @author mitra
 */
public class EncoderBinary {

    public static String encodeBinaryStrings(String s, String t) {

        int l1 = s.length();
        int l2 = t.length();

        int diff = Math.abs(l1 - l2);

        final IntStream zeros = IntStream.generate(() -> 48) //ASCII zero
                .limit(diff);

        String bigger = (l1 >= l2) ? s : t;
        String smaller = (l1 < l2) ? s : t;

        final IntUnaryOperator extractIntValue = i -> i - '0';

        int[] arr1 = bigger.chars()
                .map(extractIntValue)
                .toArray();

        //append zeros to smaller array.
        int[] arr2 = IntStream.concat(zeros, smaller.chars())
                .map(extractIntValue)
                .toArray();

        int len = arr1.length - 1;
        int[] arr = new int[arr1.length];

        int carry = 0;
        for (int i = len; i >= 0; i--) {

            int x = arr1[i];
            int y = arr2[i];

            int z = x + y + carry;

            if (z == 3) {
                z = 1;
                carry = 1;
            } else if (z == 2) {
                z = 0;
                carry = 1;
            } else {
                carry = 0;
            }

            arr[i] = z;
        }

        int[] result = (carry == 1)
                ? new int[arr.length + 1]
                : arr;

        //if carry is present append 1 to the result.
        if (carry == 1) {
            for (int i = arr.length - 1; i >= 0; i--) {
                result[i] = arr[i];
            }
            result[0] = carry;
        }

        return IntStream.of(result)
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {

        //test1
        String s = "1001110";

        String t = "1010000";

        String encoded = encodeBinaryStrings(s, t);

        System.out.println("s: " + s);
        System.out.println("t: " + t);
        System.out.println("arr: " + encoded);

        assert encoded.equals("10111100");

        //test2
        String s1 = "1001110";

        String t1 = "1000";

        String encoded1 = encodeBinaryStrings(s1, t1);

        System.out.println("s1: " + s1);
        System.out.println("t1: " + t1);
        System.out.println("arr1: " + encoded1);

        assert encoded1.equals("1010110");

    }
}
