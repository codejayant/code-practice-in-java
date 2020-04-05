package com.codejayant.linkedList.inPlaceReversal;

import com.codejayant.utils.ListNode;

/**
 * Given the head of a Singly LinkedList, reverse the LinkedList.
 * Write a function to return the new head of the reversed LinkedList.
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">LeetCode Problem</a>
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/3wENz1N4WW9">Educative Problem</a>
 */
public class ReverseLinkedList {

    /**
     * in-place iterative reversal.
     * T: O(n)
     * S: O(1)
     *
     * @param head head of the list
     * @return head of reversed linked list
     */
    private static ListNode reverse(ListNode head) {
        ListNode current = head; // current node that we will be processing
        ListNode previous = null; // previous node that we have processed
        ListNode next; // will be used to temporarily store the next node

        while (current != null) {
            next = current.next; // temporarily store the next node
            current.next = previous; // reverse the current node
            previous = current; // before we move to the next node, point previous to the current node
            current = next; // move on the next node
        }
        // after the loop current will be pointing to 'null' and 'previous' will be the new head
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
