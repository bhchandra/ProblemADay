package com.lab.problemaday.epa.chapter6strings;

/**
 * Problem 6.4 in EPA
 * <p>
 * Apply the given rules to the given array of characters
 * 1. replace each `a` by two `d`
 * 2. delete each entry containing `b`
 */
public class ReplaceAndRemove {





    public static int replaceAndRemove(char[] s, int size) {
        //forward iteration, remove `b`s and count the number of  `a`s
        int writeIndex = 0;
        int aCount = 0;

        for (int i = 0; i < size; i++) {
            if (s[i] != 'b') {
                s[writeIndex] = s[i];
                writeIndex++;
            }
            if (s[i] == 'a') aCount++;
        }

        //backward iteration : replace `a` with `dd` starting from the end.

        Character.isAlphabetic('a');
        Character.isDigit('1');
        return 1; //TODO
    }


}
