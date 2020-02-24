package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

/**
 * BST element insertion example.
 *
 * @link https://www.youtube.com/watch?v=bmaeYtlO2OE&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=3
 */
public class BinarySearchTreeInsertion {

    public static void main(String[] args) {

        TreeNode l1 = new TreeNode(10);
        TreeNode l2 = new TreeNode(-5);
        TreeNode l3 = new TreeNode(16);
        TreeNode l4 = new TreeNode(-8);
        TreeNode l5 = new TreeNode(7);
        TreeNode l6 = new TreeNode(18);


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

        TreeNode result = BinarySearchTreeInsertion.insert(l1, 6);
        DepthFirstBinaryTreeTraversal.inOrderTraversalDisplay(result);

        System.out.println();
        DepthFirstBinaryTreeTraversal.inOrderTraversalDisplay(BinarySearchTreeInsertion.insert(result, 17));
    }

    /**
     * insert element to BST.
     *
     * @param root root node of tree
     * @param data element to insert
     * @return tree with inserted element
     */
    private static TreeNode insert(TreeNode root, int data) {

        TreeNode newNode = new TreeNode(data);

        if (root == null) {
            return newNode;
        }

        TreeNode previous = null, current = root;

        // find the leaf node
        while (current != null) {
            previous = current;
            if (current.val > data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // add the new node to appropriate left or right position of current leaf node based on value
        if (previous.val > data) {
            previous.left = newNode;
        } else {
            previous.right = newNode;
        }

        return root;
    }

}
