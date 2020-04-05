package com.codejayant.linkedList.fastAndSlowPointers;

import com.codejayant.utils.ListNode;

/**
 * Problem 1: Given the head of a LinkedList with a cycle, find the length of the cycle.
 * <p>
 * Solution: We can use the above solution to find the cycle in the LinkedList.
 * Once the fast and slow pointers meet, we can save the slow pointer and iterate the whole cycle with another pointer,
 * until we see the slow pointer again to find the length of the cycle.
 *
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D">Educative Problem</a>
 */
class LinkedListCycleLength {

    /**
     * find cycle length.
     * T: O(n)
     * S: O(1)
     *
     * @param head head of the LinkedList
     * @return cycle length
     */
    private static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {    // found the cycle
                return calculateLength(slow);
            }
        }
        return 0;
    }

    private static int calculateLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);
        return cycleLength;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
    }
}
