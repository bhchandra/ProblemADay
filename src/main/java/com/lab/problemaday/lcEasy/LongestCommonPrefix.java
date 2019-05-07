package com.lab.problemaday.lcEasy;

import java.util.stream.Stream;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    /**
     * Approach 1:  Horizontal scanning
     * Intuition
     * <p>
     * LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3),…Sn)
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String start = strs[0];
        for (int i = 1; i < strs.length; i++) {
            start = longestCommonPrefix(start, strs[i]);
        }
        return start;
    }

    private static String longestCommonPrefix(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int len = Math.min(chars1.length, chars2.length);
        for (int i = 0; i < len; i++) {
            if (chars1[i] == chars2[i]) {
                sb.append(chars1[i]);
            } else {
                break;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        //["aca","cba"]
        String[] strings = Stream.of("aca", "cba")
                .toArray(String[]::new);

        System.out.println(longestCommonPrefix(strings));

        System.out.println(
                longestCommonPrefix(new String[]{"aca", "cba"})
        );

    }

}
