package com.lab.problemaday.StackInterleave;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author MITRA
 */
public class StackInterleaverTest {

    public StackInterleaverTest() {
    }

    /**
     * Test of interleave method, of class StackInterleaver.
     */
    @Test
    public void testInterleave() {

        Deque<Integer> oddQueue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5));
        StackInterleaver.interleave(oddQueue);
        //1,5,2,4,3
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(1, 5, 2, 4, 3));
        Assert.assertTrue(oddQueue.containsAll(expected));
        Assert.assertTrue(expected.containsAll(oddQueue));

        //-----------------------
        Deque<Integer> evenQueue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        //1,6,2,5,3,4
        StackInterleaver.interleave(evenQueue);
        Deque<Integer> expected2 = new ArrayDeque<>(Arrays.asList(1, 6, 2, 5, 3, 4));

        Assert.assertTrue(evenQueue.containsAll(expected2));
        Assert.assertTrue(expected2.containsAll(evenQueue));

    }

    /**
     * Test of interLeave method, of class StackInterleaver.
     */
    @Test
    public void testInterLeave() {
//        System.out.println("interLeave");
        Stack<Integer> oddstack = new Stack<>();
        oddstack.add(1);
        oddstack.add(2);
        oddstack.add(3);
        oddstack.add(4);
        oddstack.add(5);
        Stack<Integer> interLeave = StackInterleaver.interLeave(oddstack);

        //1,5,2,4,3
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(1, 5, 2, 4, 3));
        Assert.assertTrue(oddstack.containsAll(expected));
        Assert.assertTrue(expected.containsAll(oddstack));

        //-----------------------
        Stack<Integer> evenStack = new Stack<>();
        evenStack.add(1);
        evenStack.add(2);
        evenStack.add(3);
        evenStack.add(4);
        evenStack.add(5);
        evenStack.add(6);
        //1,6,2,5,3,4
        StackInterleaver.interLeave(evenStack);
        Deque<Integer> expected2 = new ArrayDeque<>(Arrays.asList(1, 6, 2, 5, 3, 4));

        Assert.assertTrue(evenStack.containsAll(expected2));
        Assert.assertTrue(expected2.containsAll(evenStack));

    }

}
