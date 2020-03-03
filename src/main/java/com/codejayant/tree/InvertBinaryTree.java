package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @link https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		System.out.println(invertRecursively(new TreeNode(4)));
		System.out.println(invertIteratively(new TreeNode(8)));
	}

	private static TreeNode invertRecursively(TreeNode root) {
		if (root == null) {
			return null;
		}

		root.right = invertRecursively(root.left);
		root.left = invertRecursively(root.right);

		return root;

	}


	private static TreeNode invertIteratively(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if (current.left != null) {
				queue.add(current.left);
			}

			if (current.right != null) {
				queue.add(current.right);
			}

		}
		return root;
	}

}
