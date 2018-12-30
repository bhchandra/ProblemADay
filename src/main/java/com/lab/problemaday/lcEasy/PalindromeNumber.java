package com.lab.problemaday.lcEasy;

public class PalindromeNumber {
    /**
     * suffers from integerOverFlow exception
     *
     * @param x
     * @return
     */
    public static boolean test(int x) {
        if (x < 0) {
            return false;
        }

        int reversed = reverse(x);
        return x == reversed;
    }

    public static int reverse(int x) {

        long val = 0;
        do {
            int r = x % 10;
            val = val * 10 + r;
            if (val != (int) val)
                throw new ArithmeticException("Overflow"); //checking for overflow, logic borrowed from Math.exactMultiply()
            x = x / 10;
        } while (x != 0);

        return (int) val;
    }

    public static void main(String[] args) {

        int x = 239999999;
        int y = 999999999;
        int q = Integer.MAX_VALUE;
        System.out.println(q);


        System.out.println(test(q));

    }


}
