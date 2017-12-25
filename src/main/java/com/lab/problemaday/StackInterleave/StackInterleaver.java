package com.lab.problemaday.StackInterleave;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *
 * Given a stack of N elements, interleave the first half of the stack with the
 * second half reversed using only one other queue. This should be done
 * in-place.
 * <br>
 * For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4,
 * 3]. If the stack is [1, 2, 3, 4], it should become [1, 4, 2, 3].
 *
 *
 * @author MITRA
 */
public class StackInterleaver {

    static <T> void interleave(Deque<T> stack) {
        int size = stack.size();
        boolean isEven = size % 2 == 0;

        int halfSize = size / 2;

        Deque<T> secondHalf = new ArrayDeque<>();

        for (int i = 0; i < halfSize; i++) {
            secondHalf.add(stack.removeLast());
        }

        while (!stack.isEmpty()) {
            if (!isEven && stack.size() == 1) {
                secondHalf.add(stack.removeFirst());
                break;
            }
            secondHalf.add(stack.removeFirst());
            stack.addLast(secondHalf.removeFirst());
            secondHalf.add(stack.removeLast());
        }

        while (!secondHalf.isEmpty()) {
            stack.add(secondHalf.removeFirst());
        }

        System.out.println(stack);

    }

    public static void main(String[] args) {

        Deque<Integer> oddQueue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5));

        StackInterleaver.interleave(oddQueue);
        //1,5,2,4,3

        Deque<Integer> evenQueue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        //1,6,2,5,3,4
        StackInterleaver.interleave(evenQueue);
    }

}
