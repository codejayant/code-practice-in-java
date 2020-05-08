package com.codejayant.tree;

import com.codejayant.utils.TreeNode;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 *
 * @see <a href="https://leetcode.com/problems/cousins-in-binary-tree/">LeetCode Problem</a>
 */
public class CousinsInBinaryTree {

    private static Map<Integer, Integer> depth;
    private static Map<Integer, TreeNode> parent;

    public static void main(String[] args) {
        doTest();
    }

    private static void doTest() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        Assert.assertFalse(isCousins(node, 4, 3));
        Assert.assertTrue(isCousins(node, 5, 4));
    }

    /**
     * T: O(n)
     * S: O(n)
     *
     * @param root root node
     * @param x first value
     * @param y second value
     * @return true if values are cousin i.e. same depth with different parent
     */
    private static boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parent = new HashMap<>();
        dfs(root, null);
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
    }

    private static void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
