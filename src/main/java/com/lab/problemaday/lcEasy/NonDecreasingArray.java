package com.lab.problemaday.lcEasy;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * <p>
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * Example 1:
 * <p>
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * <p>
 * Example 2:
 * <p>
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * <p>
 * Note: The n belongs to [1, 10,000].
 */
public class NonDecreasingArray {


    /**
     * incomplete solution **********************
     */
    public static boolean checkPossibility(int[] nums) {
        int notSatifiyingCount = 0;
        int problemIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            boolean notSatisfyingCondition = !(a <= b);
            if (notSatisfyingCondition) {
                notSatifiyingCount++;
                problemIndex = i;
                if (notSatifiyingCount > 1) return false;

            }
        }

        if (problemIndex == 0) return true;
        if (problemIndex == nums.length - 2) return true;
        return nums[problemIndex] >= nums[problemIndex + 1] && (nums[problemIndex - 1] <= nums[problemIndex + 1]);
    }

    public static boolean checkPossibility(List<Integer> nums) {
        return false;
    }


    public static void main(String[] args) {
        int[] x = IntStream.of(3, 4, 2, 3).toArray();

        System.out.println(
                checkPossibility(x)
        );

    }
}
