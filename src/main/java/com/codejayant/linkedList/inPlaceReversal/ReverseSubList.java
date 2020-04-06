package com.codejayant.linkedList.inPlaceReversal;

import com.codejayant.utils.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">LeetCode Problem</a>
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2">Educative Problem</a>
 * @see <a href="https://leetcode.com/articles/reverse-linked-list-ii/">Article</a>
 */
public class ReverseSubList {

    /**
     * in-place iterative reversal of sub-list
     * T: O(n)
     * S: O(1)
     *
     * @param head root node
     * @param p    start position of list to reverse
     * @param q    end position of list to reverse
     * @return head of modified list
     */
    private static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) {
            return head;
        }

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; ++i) {
            previous = current;
            current = current.next;
        }

        // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and
        // 'q', and the part after index 'q'
        ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next; // will be used to temporarily store the next node
        // reverse nodes between 'p' and 'q'
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the first part
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        } else {   // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = previous;
        }

        // connect with the last part
        if (lastNodeOfSubList != null) {
            lastNodeOfSubList.next = current;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        // expected value: 1 4 3 2 5
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
