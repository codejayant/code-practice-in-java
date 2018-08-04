package com.codejayant;

import com.codejayant.utils.ListNode;

import static com.codejayant.utils.LinkedListUtil.printListNode;

/**
 * Remove the nth node from the end
 * <p>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthNodeFromTheEnd {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        int nth = 3;
        printListNode(removeNthNodeFromTheEnd2Pass(l1, nth));
        printListNode(removeNthNodeFromTheEnd1Pass(l1, nth));
    }

    private static ListNode removeNthNodeFromTheEnd2Pass(ListNode head, int nth) {

        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        System.out.println("Size: " + size);

        int loc = size - nth + 1;
        if (loc < 1) {
            return head;
        }
        System.out.println("location: " + loc);
        curr = head;
        int count = 1;

        while (curr != null) {
            if (loc == 1) {
                head = head.next;
                break;
            }
            if (count == loc - 1) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            count++;
        }

        return head;
    }

    private static ListNode removeNthNodeFromTheEnd1Pass(ListNode head, int nth) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= nth + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
