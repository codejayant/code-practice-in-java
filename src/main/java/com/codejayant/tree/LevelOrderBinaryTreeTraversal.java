package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * level order traversal for binary tree.
 * one row or hierarchy at a time.
 *
 * For this use Queue DS and use property FIFO.
 *
 * @link https://www.youtube.com/watch?v=9PHkM0Jri_4&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=9
 */
public class LevelOrderBinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(10);
        TreeNode l2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(19);
        TreeNode l4 = new TreeNode(-4);
        TreeNode l5 = new TreeNode(7);
        TreeNode l6 = new TreeNode(21);

        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = l5;
        l3.left = null;
        l3.right = l6;
        l4.left = null;
        l4.right = null;
        l5.left = null;
        l5.right = null;
        l6.left = null;
        l6.right = null;

        LevelOrderBinaryTreeTraversal.levelOrderTraversal(l1);

    }

    /**
     * Implementation on level order traversal.
     * T: O(n)
     * S: O(n)
     *
     * @param root root node
     */
    private static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root); // add first node to start the queue

        while (!q.isEmpty()) {
            root = q.poll();

            System.out.print(root.val + " ");

            if (root.left != null) {
                q.add(root.left);
            }

            if (root.right != null) {
                q.add(root.right);
            }

        }

    }

}
