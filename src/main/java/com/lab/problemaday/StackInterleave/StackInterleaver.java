package com.lab.problemaday.StackInterleave;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * Incorrect Solution:<br>
     * Doesn't respect the semantics of a stack or a queue
     *
     * @param <T>
     * @param stack
     */
    public static <T> void interleave(Deque<T> stack) {
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

    /**
     * Correct solution:
     *
     * @param <T>
     * @param stack
     * @return interleaved stack
     */
    public static <T> Stack<T> interLeave(Stack<T> stack) {

        int i;
        int size = stack.size();

        Queue<T> queue = new ArrayDeque<>();

        //add stack to queue/
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        //add first half of the queue back into the queue/
        for (i = 0; i < size / 2; i++) {
            queue.add(queue.poll());
        }

        for (i = 0; i < (int) Math.ceil(size / 2.0); i++) {
            stack.add(queue.poll());
        }

        for (i = 0; i < size / 2; i++) {
            queue.add(stack.pop());
            queue.add(queue.poll());
        }

        if (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.add(queue.poll());
        }

        System.out.println("Interleaved stack: " + stack);

        return stack;
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
