package com.codejayant.common;

import com.codejayant.utils.ListNode;

import static com.codejayant.utils.LinkedListUtil.printListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list
 *              should become 4 -> 1 -> 9 after calling your function.
 *
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
public class DeleteNodeLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        printListNode(l1);

        deleteNode(l3);

        printListNode(l1);
    }

    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
