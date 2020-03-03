package com.codejayant.common;

import com.codejayant.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 * @link https://leetcode.com/problems/linked-list-cycle/
 */
public class FindLinkedListCycle {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;


        System.out.println("has cycle checked with Hash Table = " + hasCycleWithHashTable(l1));
        System.out.println("has cycle checked with two pointers = " + hasCycleWithTwoPointers(l1));
    }


    /**
     * Checked with Hash Table
     * T: O(n)
     * S: O(n)
     * @param head root
     * @return true if cyclic
     * @link https://leetcode.com/problems/linked-list-cycle/solution/
     */
    private static boolean hasCycleWithHashTable(ListNode head) {
        Set<ListNode> nodesChecked = new HashSet<>();

        while (head != null) {
            if (nodesChecked.contains(head)) {
                return true;
            } else {
                nodesChecked.add(head);
            }
            head = head.next;
        }
        return false;

    }

    /**
     * Checked with two pointers
     * T: O(n)
     * S: O(1)
     * @param head root
     * @return true if cyclic
     * @link https://leetcode.com/problems/linked-list-cycle/solution/
     */
    private static boolean hasCycleWithTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
