package com.codejayant.utils;

public class LinkedListUtil {

    public static void printListNode(ListNode node) {
        ListNode curr = node;
        if (curr == null) {
            System.out.println("Empty");
        }
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

}
