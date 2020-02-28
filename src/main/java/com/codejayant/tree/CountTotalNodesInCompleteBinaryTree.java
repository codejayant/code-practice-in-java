package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 *
 * @link https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountTotalNodesInCompleteBinaryTree {

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);

        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = l5;
        l3.left = l6;
        l3.right = null;
        l4.left = null;
        l4.right = null;
        l5.left = null;
        l5.right = null;
        l6.left = null;
        l6.right = null;

        System.out.println(CountTotalNodesInCompleteBinaryTree.countNodesBruteForce(l1));
    }

    /**
     * count total node using brute force.
     * T: O(n)
     * S: O(n)
     *
     * @param root root node
     * @return count of nodes
     */
    private static int countNodesBruteForce(TreeNode root) {

        int count = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (root != null) {
            root = q.poll();
            if (root == null) {
                break;
            }
            count++;
            q.add(root.left);
            q.add(root.right);

        }
        return count;
    }

    /**
     * count total node using BST.
     * T:
     * S:
     *
     * @param root root node
     * @return count of nodes
     */
    private static int countNodes(TreeNode root) {

        // TODO: to understand and implement
        // Medium level problem

        return 0;
    }

}
