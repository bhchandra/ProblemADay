package com.lab.problemaday.PrecisionIntegerIncrement;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Encodes a non-negative decimal integer represented by an array by
 * incrementing the number 1.
 *
 * @author MITRA
 */
public class Encoder {

    public static List<Integer> plusOne(List<Integer> list) {
        Preconditions.checkNotNull(list);
        if (list.isEmpty()) {
            return list;
        }

        List<Integer> result = new ArrayList<>(list);

        int size = result.size() - 1;

        boolean hasCarry = false;
        boolean isFirst = true;
        int index = size;
        for (int i = size; i >= 0; i--) {

            int amount = (hasCarry || isFirst) ? 1 : 0;
            isFirst = false;
            int addR = result.get(i) + amount;
            if (addR == 10) {
                result.set(i, 0);
                index = i;
                hasCarry = true;
            } else {
                result.set(i, addR);
                index = i;
                break;
            }
        }

        System.out.println("index : " + index);
        if (index == 0) {
            result.set(index, 1);
            result.add(0);
        }

        return result;
    }

    public static List<Integer> plusOneToAll(List<Integer> list) {
        Preconditions.checkNotNull(list);
        if (list.isEmpty()) {
            return list;
        }

        List<Integer> result = new ArrayList<>(list);

        ensureListIsForamtted(result);

        int size = result.size();
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int amount = 1 + carry;
            result.set(i, result.get(i) + amount);
            if (result.get(i).equals(10)) {
                result.set(i, 0);
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if (carry == 1) {
            result.add(0);
            result.set(0, 1);
        }

        return result;
    }

    //TODO
    //makse sure that each element is List is a single digit number in the range [0,9]
    private static void ensureListIsForamtted(List<Integer> list) {

        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            Integer value = it.next();
            if (value == null) {
                it.remove();
            }

            if (BW_0_AND_9.negate().test(value)) {
                //break the value into two digits.
            }

        }
    }

    private static final Predicate<Integer> GR_EQ_0 = val -> val >= 0;
    private static final Predicate<Integer> LS_EQ_9 = val -> val <= 9;
    private static final Predicate<Integer> BW_0_AND_9 = GR_EQ_0.or(LS_EQ_9);

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 1, 1, 1, 1);

        List<Integer> plusOne = plusOne(list);

        System.out.println("input: " + list);
        System.out.println("output: " + plusOne);
//-------------------------------------------------------------
        List<Integer> list2 = Arrays.asList(9, 9, 9);

        List<Integer> plusOne2 = plusOne(list2);

        System.out.println("input: " + list2);
        System.out.println("output: " + plusOne2);

    }

}
