package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.Stack;

/**
 * Iterative pre order traversal of binary tree.
 * Using one stack to replace system's stack which is being used in recursive way.
 *
 * @link https://www.youtube.com/watch?v=elQcrJrfObg&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=11
 */
public class PreOrderIterativeTraversal {

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

//        OutPut: Pre-Order: 10 2 6 5 8 3

        PreOrderIterativeTraversal.traversalIterativePreOrder(l1);
    }

    /**
     * method implementation on pre order traversal iteratively using one stacks.
     *
     * @param root root node
     */
    private static void traversalIterativePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty()) {
            root = s1.pop();
            System.out.print(root.val + " ");

            // add children right to left in stack so that left child is pop first.
            if (root.right != null) {
                s1.push(root.right);
            }

            if (root.left != null) {
                s1.push(root.left);
            }
        }

    }

}
