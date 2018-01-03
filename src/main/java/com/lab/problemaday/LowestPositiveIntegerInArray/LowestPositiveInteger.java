package com.lab.problemaday.LowestPositiveIntegerInArray;

import java.util.Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear
 * time and constant space. In other words, find the lowest positive integer
 * that does not exist in the array. The array can contain duplicates and
 * negative numbers as well.
 * <br><br>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0]
 * should give 3.
 * <br><br>
 * You can modify the input array in-place.
 *
 * @author MITRA
 */
public class LowestPositiveInteger {

    public static int findFirstMissingPositiveNumber(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            //filter out negative numbers and numbers greater than lenght of array/
            if ((nums[i] <= 0) || (nums[i] > nums.length)) {
                continue;
            }

            System.out.println("loop: " + i);
            //swap elements between the indices/
            while ((i + 1 != nums[i]) && nums[i] <= nums.length && nums[i] > 0) {
                int v = nums[i];
                nums[i] = nums[v - 1];
                nums[v - 1] = v;
                if (nums[i] == nums[v - 1]) {
                    break;
                }
                i++;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length + 1;
    }

    //testing/
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};

        System.out.println(
                //Ans = 2
                findFirstMissingPositiveNumber(nums)
        );

        int[] nums2 = new int[]{1, 2, 0};

        System.out.println(
                findFirstMissingPositiveNumber(nums2)
        );
    }

}
