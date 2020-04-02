package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 *
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">LeetCode Problem</a>
 */
public class MinimumBinaryTreeDepth {

    /**
     * Find minimum depth of binary tree.
     * T: O(n)
     * S: O(m) : m is max node in a level
     *
     * @param root root node
     * @return minimum depth of binary tree
     */
    private static int findDepth(TreeNode root) {

        int minDepth = 0;

        if (root == null) {
            return minDepth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            minDepth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // if currentNode is a leaf node, minimum depth is found by returning with +1
                if (currentNode.left == null && currentNode.right == null) {
                    return minDepth;
                }

                // add child of current node
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }

}
