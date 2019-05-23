package com.lab.problemaday.codewars;

import java.util.Arrays;

/**
 * Given two arrays a and b write a function comp(a, b) that checks whether the two arrays have the "same" elements,
 * with the same multiplicities. "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
 * Examples
 * Valid arrays
 * <p>
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
 * <p>
 * comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121,
 * 20736 the square of 144, 361 the square of 19, 25921 the square of 161, and so on.
 */
public class AreSame {

    public static boolean comp(int[] a, int[] b) {

        if (a == null | b == null) return false;
        else if (a.length == 0 && b.length == 0) return true;
        else if (a.length == 0) return false;
        else if (b.length == 0) return false;


        int[] sqrtB = Arrays.stream(b)
                .map(i -> (int) Math.sqrt(i))
                .toArray();

        System.out.println(Arrays.toString(sqrtB));


        return arr1ContainsAllInArr2(a, sqrtB);

    }

    private static boolean arr1ContainsAllInArr2(int[] arr1, int[] arr2) {
        for (int value : arr2) {
            if (!contains(value, arr1)) return false;
        }
        return true;
    }

    private static boolean contains(int a, int[] arr2) {
        for (int value : arr2) {
            if (a == value) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};


        System.out.println("a : " + Arrays.toString(a));

        System.out.println("b : " + Arrays.toString(b));

        System.out.println(comp(a, b));

    }
}
