package com.lab.problemaday.lcMedium;


import lombok.var;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 */
public class AddTwoNumbers {

    /*
      Example:

      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
      Output: 7 -> 0 -> 8
      Explanation: 342 + 465 = 807.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //always store the result in l1,
        //if the number of nodes in l2 > l1, use the remanining nodes from l2 to store the result.
        //use Transition to link l1 and l2 if noOfNodes(l2) >  noOfNodes(l1)

        ListNode head = l1;
        ListNode l1Last = null;
        ListNode l2Last = null;

        int sum = 0;
        int overflow = 0;

        //Transition

        // link the last node of l1 to the node of l2 where l2 exceeds l1 in nunber of nodes

        // l1 : [a]->[b]->[c]->[d]
        // l2 : [d]->[e]->[f]->[g]->[h]->[i]

        // l1 : [a]->[b]->[c]->[d]        // [d] now points to [h]
        //                        \
        //                         \
        // l2 : [d]->[e]->[f]->[g]->[h]->[i]

        boolean transitionDone = false;

        while (l1 != null || l2 != null) {

            sum = ((l1 == null) ? 0 : l1.val)
                    + ((l2 == null) ? 0 : l2.val) + overflow;

            if (sum >= 10) {
                overflow = sum / 10;
                sum = sum % 10;
            } else {
                overflow = 0;
            }

            if (l1 != null) {
                l1.val = sum;
            } else if (l2 != null) { //l2 has more nodes than l1
                l2.val = sum;
                if (!transitionDone && l1Last != null) {
                    l1Last.next = l2; //link the last node of l1 to the now node of l2
                    transitionDone = true;
                }
            }


            if (l1 != null) {
                if (l1.next == null) l1Last = l1; //find the last node of l1
                l1 = l1.next;
            }

            if (l2 != null) {
                if (l2.next == null) l2Last = l2; //find the last node of l2
                l2 = l2.next;
            }

        }


        if (overflow != 0) {
            if (!transitionDone) {
                l1Last.next = new ListNode(overflow);
            } else {
                l2Last.next = new ListNode(overflow);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        var node11 = ListNode.of(1);
        var node12 = ListNode.of(5);
        var node13 = ListNode.of(9);
        var node14 = ListNode.of(9);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        var node21 = ListNode.of(1);
        var node22 = ListNode.of(2);
        var node23 = ListNode.of(3);

        node21.next = node22;
        node22.next = node23;


        System.out.println("l1 : " + node11);
        System.out.println("l2 : " + node12);


        ListNode result = addTwoNumbers(node11, node21);

        System.out.println("result : " + result);


    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        static ListNode of(int val) {
            return new ListNode(val);
        }

        @Override
        public String toString() {
            return "[" + val + "]" +
                    ((this.next == null) ? "" : "->" + next.toString());
        }

    }


}
