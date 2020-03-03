package com.codejayant.common;

import com.codejayant.utils.LinkedListUtil;
import com.codejayant.utils.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * Link: https://leetcode.com/problems/remove-linked-list-elements/description/
 */
public class RemoveLinkedListElement {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next.next = new ListNode(6);

        LinkedListUtil.printListNode(l1);

        System.out.println("-------------------");

        int removeElementValue = 6;
        removeElementsIterativeUsingDummyHead(l1, removeElementValue);

        LinkedListUtil.printListNode(removeElementsIterativeUsingDummyHead(l1, removeElementValue));

    }

    private static ListNode removeElementsIterativeUsingDummyHead(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) { //condition
                if (curr.next.next == null)  {  //tail
                    curr.next = null;
                    break;
                }

                // For Valid Condition
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    private static ListNode removeElementsRecursive(ListNode head, int val) {
        // TODO
        return null;
    }
}
