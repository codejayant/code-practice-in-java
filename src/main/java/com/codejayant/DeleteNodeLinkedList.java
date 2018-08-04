package com.codejayant;

import com.codejayant.utils.ListNode;

import static com.codejayant.utils.LinkedListUtil.printListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
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
