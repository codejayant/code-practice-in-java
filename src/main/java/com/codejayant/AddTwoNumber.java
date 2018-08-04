package com.codejayant;

import com.codejayant.utils.ListNode;

import static com.codejayant.utils.LinkedListUtil.printListNode;

/**
 * Add two number present in linked list in reverse order
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumber {

    public static void main(String args[]) {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(2);
        l21.next = l22;
        l22.next = l23;


        ListNode sum = addTwoNumbers(l11, l21);
        printListNode(sum);
    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sl = new ListNode(0);
        ListNode curr = sl;
        int temp = 0;

        while (l1 != null || l2 != null) {
            int s1 = l1 != null ? l1.val : 0;
            int s2 = l2 != null ? l2.val : 0;

            int sum = temp + s1 + s2;
            temp = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (temp > 0) {
            curr.next = new ListNode(temp);
        }
        return sl.next;
    }

}
