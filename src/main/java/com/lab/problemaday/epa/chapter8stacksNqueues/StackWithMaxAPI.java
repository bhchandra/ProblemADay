package com.lab.problemaday.epa.chapter8stacksNqueues;


import lombok.NonNull;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A stack with max operation in addition to push and pop.
 * The max() should return the maximum value in the stack.
 * <p>
 * Problem 8.1
 */
public class StackWithMaxAPI<E extends Comparable<E>> {

    /**
     * to improve the time complexity of push and pop,
     * we store the current max(which changes when an element is added and removed ) value with every element add
     * <p>
     * <p>
     * This results in a time-complexity of O(1) and space-complexity of O(n)
     */

    private static class ElementNCachedMax<T extends Comparable<T>> {
        private final T element;
        private final T associatedMax;

        private ElementNCachedMax(T element, T associatedMax) {
            this.element = element;
            this.associatedMax = associatedMax;
        }

        public static <T extends Comparable<T>> ElementNCachedMax<T> of(T element, T associatedMax) {
            return new ElementNCachedMax<>(element, associatedMax);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }


    private final Deque<ElementNCachedMax<E>> deque;

    private StackWithMaxAPI() {
        this.deque = new ArrayDeque<>();
    }

    public static <E extends Comparable<E>> StackWithMaxAPI<E> create() {
        return new StackWithMaxAPI<>();
    }

    public boolean empty() {
        return deque.isEmpty();
    }


    public E pop() {
        if (empty()) throw new IllegalStateException("stack is empty");
        return deque.pop().element;
    }


    public StackWithMaxAPI<E> push(@NonNull E element) {
        if (!empty()) {
            E currentMax = deque.peek().associatedMax;
            E updatedMax = element.compareTo(currentMax) >= 0 ? element : currentMax;
            deque.push(ElementNCachedMax.of(element, updatedMax));
        } else {
            deque.push(ElementNCachedMax.of(element, element));
        }
        return this;
    }


    public E max() {
        if (empty()) throw new IllegalStateException("stack is empty");
        return deque.peek().associatedMax;
    }

    @Override
    public String toString() {
        return deque.toString();
    }

    public static void main(String[] args) {

        StackWithMaxAPI<Integer> stack = StackWithMaxAPI.create();

        stack.push(2)
                .push(6)
                .push(100)
                .push(6)
                .push(4);


        assert stack.max() == 100;

        stack.pop();
        stack.pop();
        stack.pop();

        assert stack.max() == 6;


    }
}