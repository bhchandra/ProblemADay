package com.lab.problemaday.lcEasy;


import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    /**
     * brute force: o(n^2)
     */
    public static List<Integer> indices(@NonNull List<Integer> nums, @NonNull Integer sum) {
        if (nums.isEmpty()) return emptyList();

        for (int i = 0; i < nums.size(); i++) {
            Integer n1 = nums.get(i);
            Integer n2 = sum - n1;
            for (int j = i + 1; j < nums.size(); j++) {
                if (n2.equals(nums.get(j))) return Arrays.asList(i, j);
            }
        }
        return emptyList();
    }

    public static int[] twoSum(int[] nums, int target) {
        return indices(IntStream.of(nums).boxed().collect(toList()), target)
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }


    public static void main(String[] args) {

        List<Integer> indices = indices(Arrays.asList(2, 7, 11, 15), 9);

        System.out.println(indices);

        List<Integer> indices2 = indices(Arrays.asList(2, 5, 5, 11), 10);

        System.out.println(indices2);


    }

}
