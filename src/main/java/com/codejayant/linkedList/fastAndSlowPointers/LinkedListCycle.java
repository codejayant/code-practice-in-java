package com.codejayant.linkedList.fastAndSlowPointers;

import com.codejayant.utils.ListNode;

/**
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">LeetCode Problem</a>
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D">Educative Problem</a>
 */
class LinkedListCycle {

    /**
     * Time Complexity #
     * As we have concluded above, once the slow pointer enters the cycle, the fast pointer will meet the slow pointer in the same loop.
     * Therefore, the time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.
     *
     * Space Complexity #
     * The algorithm runs in constant space O(1).
     *
     * @param head root node
     * @return true if list is cyclic
     */
    private static boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }
}
