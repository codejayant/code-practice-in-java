package com.codejayant.tree;

import com.codejayant.utils.TreeNode;

import java.util.Stack;

/**
 * post order iterative traversal using two stacks.
 * Pull node from tree, insert into the first stack in order: root, left and right and then pop from stack 1 and push to stack 2.
 * Once completed, print from stack 2.
 *
 * @link https://www.youtube.com/watch?v=qT65HltK2uE&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=10
 *
 * @link article: https://leetcode.com/articles/binary-tree-postorder-transversal/
 */
public class PostOrderIterativeTraversalTwoStack {

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

//        OutPut: Post-Order: 6 2 8 3 5 10

        PostOrderIterativeTraversalTwoStack.postOrderTraversal(l1);
    }

    /**
     * method implementation on post order traversal iteratively using two stacks.
     *
     * @param root root node
     */
    private static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            root = s1.pop();

            s2.push(root);

            if (root.left != null) {
                s1.push(root.left);
            }

            if (root.right != null) {
                s1.push(root.right);
            }
        }

        System.out.print("PostOrder: ");
        while (!s2.isEmpty()) {
            root = s2.pop();
            System.out.print(root.val + " ");
        }

    }

}
