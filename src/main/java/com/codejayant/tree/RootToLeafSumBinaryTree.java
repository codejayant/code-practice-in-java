package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * identify root to leaf sum path for a value and print the path.
 *
 * @link https://www.youtube.com/watch?v=Jg4E4KZstFE&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=7
 */
public class RootToLeafSumBinaryTree {

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(10);
        TreeNode l2 = new TreeNode(16);
        TreeNode l3 = new TreeNode(5);
        TreeNode l4 = new TreeNode(-3);
        TreeNode l5 = new TreeNode(6);
        TreeNode l6 = new TreeNode(11);


        l1.left = l2;
        l1.right = l3;
        l2.left = null;
        l2.right = l4;
        l3.left = l5;
        l3.right = l6;
        l4.left = null;
        l4.right = null;
        l5.left = null;
        l5.right = null;
        l6.left = null;
        l6.right = null;

        List<Integer> result = new ArrayList<>();

        final boolean isPathAvailable = rootToLeafSum(l1, 26, result);

        System.out.println("path in binary tree available? " + isPathAvailable + " with actual path: " + Arrays.toString(result.toArray()));
    }

    private static boolean rootToLeafSum(TreeNode root, int sum, List<Integer> result) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {  // leaf node
            if (root.val == sum) {
                result.add(root.val);
                return true;
            } else {
                return false;
            }
        }

        // left recursion
        if (rootToLeafSum(root.left, sum - root.val, result)) {
            result.add(root.val);
            return true;
        }

        // right recursion
        if (rootToLeafSum(root.right, sum - root.val, result)) {
            result.add(root.val);
            return true;
        }

        return false;
    }

}
