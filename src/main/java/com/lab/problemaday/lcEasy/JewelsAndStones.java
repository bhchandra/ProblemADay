package com.lab.problemaday.lcEasy;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * <p>
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * <p>
 * Note:
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {

    /**
     * brute force, o(n^2)
     */
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int k = 0; k < S.length(); k++) {
            for (int i = 0; i < J.length(); i++) {
                if (J.charAt(i) == S.charAt(k)) count++;
            }
        }
        return count;
    }

    /**
     * runs faster, JVM optimized ??
     */
    public int numJewelsInStonesFaster(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) > -1)
                count++;
        }
        return count;
    }

    /**
     * Time : O(n), Space O(n)
     */
    public int numJewelsInStonesWithMap(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int k = 0; k < S.length(); k++) {
            if (set.contains(S.charAt(k))) count++;
        }
        return count;
    }
}
