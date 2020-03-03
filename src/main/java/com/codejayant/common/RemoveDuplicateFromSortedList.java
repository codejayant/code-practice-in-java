package com.codejayant.common;

import com.codejayant.utils.LinkedListUtil;
import com.codejayant.utils.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicateFromSortedList {

    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        ListNode result = deleteDuplicates(l1);

        LinkedListUtil.printListNode(result);
        LinkedListUtil.printListNode(l1);
    }

    /**
     * T: O(n) going through each list
     * S: O(1) constant space introduced
     * @param head root node
     * @return result list
     */
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode c = head;

        while (c != null && c.next != null) {
            if (c.next.val == c.val) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }
        return head;
    }
}
