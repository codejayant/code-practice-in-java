package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

/**
 * Find max height of a binary tree.
 *
 * @link https://www.youtube.com/watch?v=_SiwrPXG9-g&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=6
 */
public class FindMaxHeightOfBinaryTree {

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


        System.out.println("height of binary tree: " + findMaxHeight(l1));
    }

    private static int findMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findMaxHeight(root.left);
        int rightHeight = findMaxHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
