package com.codejayant.tree;

import com.codejayant.utils.TreeNodeMultiple;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 *
 * Constraints:
 *
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 *
 * @link https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 * @link article: https://leetcode.com/articles/binary-tree-preorder-transversal/
 */
public class TraversalIterativePreOrderNChild {

	public static void main(String[] args) {
		preorderIterativeTraversal(null);
	}

	private static List<Integer> preorderIterativeTraversal(TreeNodeMultiple root) {

		LinkedList<TreeNodeMultiple> stack = new LinkedList<>();
		List<Integer> result = new LinkedList<>();

		if (root == null) {
			return result;
		}
		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNodeMultiple node = stack.pollLast(); // equivalent to stack pop
			result.add(node.val);
			Collections.reverse(node.children); // reverse the children entry
			for (TreeNodeMultiple child : node.children) {
				stack.add(child); // add children right to left
			}
		}
		return result;
	}

}
