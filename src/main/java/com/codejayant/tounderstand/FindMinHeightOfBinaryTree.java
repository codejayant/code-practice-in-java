package com.codejayant.tounderstand;

import com.codejayant.utils.TreeNode;

/**
 * category: Tree
 */
public class FindMinHeightOfBinaryTree {

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


        System.out.println("min height of binary tree: " + findMinHeight(l1));


        TreeNode m1 = new TreeNode(10);
        TreeNode m2 = new TreeNode(2);

        m1.left = m2;
        m1.right = null;
        System.out.println("min height of binary tree: " + findMinHeight(m1));

    }

    private static int findMinHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findMinHeight(root.left);
        int rightHeight = findMinHeight(root.right);

        return Math.min(leftHeight, rightHeight) + 1;
    }


}
