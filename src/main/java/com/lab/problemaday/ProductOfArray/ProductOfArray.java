package com.lab.problemaday.ProductOfArray;

/**
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original
 * array except the one at i. Solve it without using division and in O(n) time.
 * <br>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would
 * be [2, 3, 6].
 *
 *
 * @author MITRA
 */
public class ProductOfArray {
    
    /**
     * solution: 
     * @see <a href = https://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div>solution</a>
     * @param arr
     * @return the product array.
     */
    public static long[] productArray(int[] arr) {
        final int len = arr.length;

        int[] prefix = new int[len];
        int[] suffix = new int[len];

        int mul = 1;
        for (int i = 0; i < len; i++) {
            prefix[i] = mul;
            mul = mul * arr[i];
        }

        mul = 1;
        for (int i = len - 1; i >= 0; i--) {
            suffix[i] = mul;
            mul = mul * arr[i];
        }

        long[] product = new long[len];
        for (int i = 0; i < len; i++) {
            product[i] = prefix[i] * (long) suffix[i];
        }

        return product;
    }

}
