package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

/**
 * Recursive traversal of binary tree: pre-order, post-order and in-order.
 */
public class DepthFirstBinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(10);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(5);
        TreeNode l4 = new TreeNode(6);
        TreeNode l5 = new TreeNode(8);
        TreeNode l6 = new TreeNode(3);


        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = null;
        l3.left = l5;
        l3.right = l6;
        l4.left = null;
        l4.right = null;
        l5.left = null;
        l5.right = null;
        l6.left = null;
        l6.right = null;


        System.out.print("Pre-Order: ");
        preOrder(l1);
        System.out.println();
        System.out.print("Post-Order: ");
        postOrder(l1);
        System.out.println();
        System.out.print("In-Order: ");
        inOrder(l1);
    }

    /**
     * Order: Visited - Left - Right
     * @param node root node
     */
    private static void preOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Order: Left - Right - Visited
     * @param node root node
     */
    private static void postOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    /**
     * Order: Left - Visited - Right
     * @param node root node
     */
    private static void inOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

}
