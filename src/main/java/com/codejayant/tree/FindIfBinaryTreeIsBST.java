package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

/**
 * find if a binary tree is a binary search tree.
 * <p>
 * Use min max value range to find out if an element is in correct place with appropriate value.
 *
 * @link https://www.youtube.com/watch?v=MILxfAbIhrE&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=8
 */
public class FindIfBinaryTreeIsBST {

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

        System.out.println("is tree BST? : " + isBST(l1, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    /**
     * is passed tree BST?
     *
     * @param root root tree node
     * @param min  min value
     * @param max  max value
     * @return true if BST
     */
    private static boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }


}
