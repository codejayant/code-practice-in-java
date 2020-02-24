package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

/**
 * find size of binary tree which means find total number of nodes of a binary tree.
 *
 * @link https://www.youtube.com/watch?v=NA8B84DZYSA&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=5
 */
public class FindSizeOfBinaryTree {

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


        System.out.println("size of binary tree: " + findSize(l1));
    }

    private static int findSize(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findSize(root.left) + findSize(root.right) + 1;
    }

}
