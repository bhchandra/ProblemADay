package com.lab.problemaday.lcEasy;

public class MergeSortedLists {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        if (l1 == null && l2 == null) {
            return null;
        } else if (l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        }

        ListNode head = l1.val < l2.val ? l1 : l2;

        if (l1.val < l2.val) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }

        ListNode node = head;


        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {

                if (l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }

                node = node.next;

            }

            if (l1 != null && l2 == null) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;

            }

            if (l2 != null && l1 == null) {
                node.next = l2;
                l2 = l2.next;
                node = node.next;

            }


        }


        return head;

    }


    public static void main(String[] args) {
        //l1 = [1, 2, 4]
        //l2 = [1, 3, 4]


        //required out = [1,1,2,3,4,4]
        //actual out = [1,1,2,4]
    }
}
