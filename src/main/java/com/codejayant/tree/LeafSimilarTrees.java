package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 * Tree: [3, 5, 1, 6, 2, 9, 8, null, null, 7, 4, null, null, null, null]
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Note:
 *
 * Both of the given trees will have between 1 and 100 nodes.
 *
 * DFS will go left to right hence printing all leaf node values left to right
 *
 * @link https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(1);
        TreeNode l4 = new TreeNode(6);
        TreeNode l5 = new TreeNode(2);
        TreeNode l6 = new TreeNode(9);
        TreeNode l7 = new TreeNode(8);
        TreeNode l8 = new TreeNode(7);
        TreeNode l9 = new TreeNode(4);

        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = l5;
        l3.left = l6;
        l3.right = l7;
        l4.left = null;
        l4.right = null;
        l5.left = l8;
        l5.right = l9;
        l6.left = null;
        l6.right = null;
        l7.left = null;
        l7.right = null;
        l8.left = null;
        l8.right = null;
        l9.left = null;
        l9.right = null;

        TreeNode ll1 = new TreeNode(3);
        TreeNode ll2 = new TreeNode(5);
        TreeNode ll3 = new TreeNode(1);
        TreeNode ll4 = new TreeNode(6);
        TreeNode ll5 = new TreeNode(2);
        TreeNode ll6 = new TreeNode(9);
        TreeNode ll7 = new TreeNode(8);
        TreeNode ll8 = new TreeNode(7);
        TreeNode ll9 = new TreeNode(4);

        ll1.left = ll2;
        ll1.right = ll3;
        ll2.left = ll4;
        ll2.right = ll5;
        ll3.left = ll6;
        ll3.right = ll7;
        ll4.left = null;
        ll4.right = null;
        ll5.left = ll8;
        ll5.right = ll9;
        ll6.left = null;
        ll6.right = null;
        ll7.left = null;
        ll7.right = null;
        ll8.left = null;
        ll8.right = null;
        ll9.left = null;
        ll9.right = null;

        System.out.println(LeafSimilarTrees.leafSimilar(l1, ll1));

    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }



}
