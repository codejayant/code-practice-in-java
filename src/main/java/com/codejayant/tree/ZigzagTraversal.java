package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">LeetCode Problem</a>
 */
public class ZigzagTraversal {

    /**
     * Traverse binary tree and save result in zigzag pattern as asked.
     * T: O(n)
     * S: O(n)
     *
     * @param root root node
     * @return result list
     */
    private static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverseList = false;
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                if (reverseList) {
                    levelList.add(0, currentNode.val);
                } else {
                    levelList.add(currentNode.val);
                }
            }
            result.add(levelList);
            reverseList = !reverseList;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
