package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.Stack;

/**
 * In Order iterative traversal of binary tree using stack.
 *
 * @link https://www.youtube.com/watch?v=nzmtCFNae9k&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=12
 */
public class TraversalIterativeInOrder {

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

//        OutPut: In-Order: 6 2 10 8 5 3

        TraversalIterativeInOrder.inOrderIterativeTraversal(l1);
    }

    /**
     * method implementation of in order iterative traversal of binary tree.
     * T: O(n)
     * S: O(h) where h is height and worst case of h is n.
     *
     * @param root root node
     */
    private static void inOrderIterativeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        while (true) {
            if (root != null) {
                s1.push(root);
                root = root.left;
            } else {
                if (s1.isEmpty()) { break; }

                root = s1.pop();

                System.out.print(root.val + " ");

                root = root.right;

            }
        }

    }
}
