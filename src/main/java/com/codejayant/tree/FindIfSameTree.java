package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

/**
 * find if two tree are same wrt values.
 *
 * @link https://www.youtube.com/watch?v=ySDDslG8wws&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=4
 */
public class FindIfSameTree {


    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(11);
        TreeNode l2 = new TreeNode(15);
        TreeNode l3 = new TreeNode(18);
        TreeNode l4 = new TreeNode(21);


        l1.left = l2;
        l1.right = l3;
        l2.left = null;
        l2.right = null;
        l3.left = l4;
        l3.right = null;
        l4.left = null;
        l4.right = null;

        TreeNode m1 = new TreeNode(11);
        TreeNode m2 = new TreeNode(15);
        TreeNode m3 = new TreeNode(18);
        TreeNode m4 = new TreeNode(21);


        m1.left = m2;
        m1.right = m3;
        m2.left = null;
        m2.right = null;
        m3.left = m4;
        m3.right = null;
        m4.left = null;
        m4.right = null;


        System.out.println("isSameTree ? " + isSameTree(l1, m1));
    }

    /**
     * check if two trees are same.
     *
     * @param t1 tree 1
     * @param t2 tree 2
     * @return true if same
     */
    private static boolean isSameTree(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.val != t2.val) {
            return false;
        } else {
            return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        }
    }

}
