package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

/**
 * Search an element in binary search tree.
 */
public class BinarySearchTreeSearch {


    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(10);
        TreeNode l2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(60);
        TreeNode l4 = new TreeNode(2);
        TreeNode l5 = new TreeNode(40);
        TreeNode l6 = new TreeNode(80);


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

        System.out.println(search(l1, 60));
        System.out.println(search(l1, 2));
        System.out.println(search(l1, 80));
        System.out.println(search(l1, 59));

    }


    /**
     * search element <code>val</code> in tree with root <code>node</code>.
     * T: O(n)
     * S: O(n)
     *
     * @param node root node of tree
     * @param val value to search for
     * @return node containing value passed.
     */
    private static TreeNode search(TreeNode node, int val) {

        if (node == null) {
            return null;
        }

        if (node.val == val) {
            return node;
        } else if (node.val > val) {
            return search(node.left, val);
        } else {
            return search(node.right, val);
        }
    }

}
