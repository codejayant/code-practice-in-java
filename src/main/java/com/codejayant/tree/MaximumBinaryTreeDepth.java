package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class MaximumBinaryTreeDepth {

        /**
         * Find minimum depth of binary tree.
         * T: O(n)
         * S: O(m) : m is max node in a level
         *
         * @param root root node
         * @return minimum depth of binary tree
         */
        private static int findDepth(TreeNode root) {

        int maxDepth = 0;

        if (root == null) {
            return maxDepth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            maxDepth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // add child of current node
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
        }

        return maxDepth;
    }

        public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Max Depth: " + MaximumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Max Depth: " + MaximumBinaryTreeDepth.findDepth(root));
    }

}
