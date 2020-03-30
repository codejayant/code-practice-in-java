package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">LeetCode Problem</a>
 * @see <a href="https://www.techiedelight.com/find-diameter-of-a-binary-tree/">Solution Explaination</a>
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.print("The diameter of the tree is " + diameterOfBinaryTree(root));
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger diameter = new AtomicInteger(0);
        depth(root, diameter);
        return diameter.get();
    }

    private static int depth(TreeNode node, AtomicInteger diameter) {
        if (node == null) {
            return 0;
        }

        int leftValue = depth(node.left, diameter);
        int rightValue = depth(node.right, diameter);
        diameter.set(Math.max(diameter.get(), leftValue + rightValue + 1));
        return Math.max(leftValue, rightValue) + 1;
    }
}
