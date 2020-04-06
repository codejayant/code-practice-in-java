package com.codejayant.linkedList.inPlaceReversal;

import com.codejayant.utils.ListNode;

/**
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
 * <p>
 * If, in the end, you are left with a sub-list with less than ‘k’ elements,
 * reverse it in one method and don't in another method.
 *
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/RMZylvkGznR">Educative Problem with reversal of sub-list less than 'k'</a>
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group">LeetCode Problem with no reversal of sub-list less than 'k'</a>
 */
public class ReverseEveryKElements {

    /**
     * in-place iterative reversal of sub-list
     * T: O(n)
     * S: O(1)
     *
     * @param head root node
     * @param k    length of sub-list
     * @return head of modified list
     */
    private static ListNode reverseEvenWithElementsCountLessThanK(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;

        while (true) {
            // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and
            // 'q', and the part after index 'q'
            ListNode lastNodeOfPreviousPart = previous; // points to the node at index 'p-1'
            // after reversing the LinkedList 'current' will become the last node of the sub-list
            ListNode lastNodeOfSubList = current;
            ListNode next; // will be used to temporarily store the next node
            // reverse nodes between 'p' and 'q'
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // connect with the first part
            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
            } else {   // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
                head = previous;
            }

            // connect with the last part
            lastNodeOfSubList.next = current;

            if (current == null) {
                break;
            }

            previous = lastNodeOfSubList;
        }

        return head;
    }

    private static ListNode reverseButDoNotReverseElementLessThanK(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;

        while (true) {
            // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and
            // 'q', and the part after index 'q'
            ListNode lastNodeOfPreviousPart = previous; // points to the node at index 'p-1'
            // after reversing the LinkedList 'current' will become the last node of the sub-list
            ListNode lastNodeOfSubList = current;
            ListNode next; // will be used to temporarily store the next node
            // reverse nodes between 'p' and 'q'
            ListNode forCounter = current;
            int count = 0;
            while (count < k && forCounter != null) {
                forCounter = forCounter.next;
                count++;
            }

            if (count < k) {
                break;
            }

            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // connect with the first part
            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
            } else {   // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
                head = previous;
            }

            // connect with the last part
            lastNodeOfSubList.next = current;

            if (current == null) {
                break;
            }

            previous = lastNodeOfSubList;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverseEvenWithElementsCountLessThanK(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println();


        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode result1 = ReverseEveryKElements.reverseButDoNotReverseElementLessThanK(head1, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
    }

}
