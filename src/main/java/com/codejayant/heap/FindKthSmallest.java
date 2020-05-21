package com.codejayant.heap;

import com.codejayant.utils.TreeNode;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1 3 / \ 1   4 \ 2 Output: 1 Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3 5 / \ 3   6 / \ 2   4 / 1 Output: 3 Follow up: What
 * if the BST is modified (insert/delete operations) often and you need to find the kth smallest
 * frequently? How would you optimize the kthSmallest routine?
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of elements of the BST is between 1 to 10^4. You may assume k is always valid, 1 ≤ k ≤
 * BST's total elements.
 *
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">LeetCode Problem</a>
 * @see <a href="https://leetcode.com/articles/kth-smallest-element-in-a-bst/">LeetCode Article</a>
 */
public class FindKthSmallest {

  /**
   * find k-th smalled integer using MaxHeap
   * <p>
   * T:
   * <p>
   * S:
   *
   * @param root root node of the {@link TreeNode}
   * @param k    k-th smallest integer to find
   * @return k-th smallest integer
   */
  public static int kthSmallestUsingMaxHeap(TreeNode root, int k) {
    if (root == null) {
      return -1;
    }
    PriorityQueue<TreeNode> maxHeap =
        new PriorityQueue<>(k, (TreeNode tn1, TreeNode tn2) -> Integer.compare(tn2.val, tn1.val));

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      if (maxHeap.size() < k) {
        maxHeap.add(current);
      } else if (maxHeap.peek() != null && maxHeap.peek().val > current.val) {
        maxHeap.poll();
        maxHeap.add(current);
      }
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }

    }

    return maxHeap.peek() == null ? -1 : maxHeap.peek().val;
  }

  /**
   * find k-th smalled integer using recursive inorder DFS.
   * <p>
   * T: O(n)
   * <p>
   * S: O(n)
   *
   * @param root root node of the {@link TreeNode}
   * @param k    k-th smallest integer to find
   * @return k-th smallest integer
   */
  public static int kthSmallestUsingRecursiveDFS(TreeNode root, int k) {
    ArrayList<Integer> integers = inOrderRecursiveDFS(root, new ArrayList<>());
    return integers.get(k - 1);
  }

  /**
   * In Order Depth First Search using Recursion
   *
   * @param node     {@link TreeNode} instance
   * @param integers list to store number in ascending order
   * @return list with numbers in ascending order
   */
  private static ArrayList<Integer> inOrderRecursiveDFS(
      TreeNode node,
      ArrayList<Integer> integers) {
    if (node == null) {
      return integers;
    }
    inOrderRecursiveDFS(node.left, integers);
    integers.add(node.val);
    inOrderRecursiveDFS(node.right, integers);
    return integers;
  }

  /**
   * find k-th smalled integer using iterative inorder DFS.
   * <p>
   * Time complexity : O(H + k), where H is a tree height. This complexity is defined by the stack,
   * which contains at least H + k elements, since before starting to pop out one has to go down to
   * a leaf. This results in O(logN + k) for the balanced tree and O(N + k) for completely
   * unbalanced tree with all the nodes in the left subtree.
   * <p>
   * Space complexity : O(H + k), the same as for time complexity, O(N + k) in the worst case, and
   * O(logN + k) in the average case.
   *
   * @param root root node of the {@link TreeNode}
   * @param k    k-th smallest integer to find
   * @return k-th smallest integer
   */
  public static int kthSmallestUsingIterativeDFS(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();

    while (true) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) {
        return root.val;
      }
      root = root.right;
    }
  }

  public static void main(String[] args) {
    doTestUsingMaxHeap();
    doTestUsingDFSWithRecursion();
    doTestUsingDFSWithIteration();
  }

  private static void doTestUsingMaxHeap() {

    TreeNode node = new TreeNode(2);
    node.right = new TreeNode(1);

    Assert.assertEquals(1, kthSmallestUsingMaxHeap(node, 1));

    node = new TreeNode(2);
    node.left = new TreeNode(1);
    Assert.assertEquals(2, kthSmallestUsingMaxHeap(node, 2));

    node = new TreeNode(3);
    node.left = new TreeNode(1);
    node.right = new TreeNode(4);
    node.left.right = new TreeNode(2);
    Assert.assertEquals(1, kthSmallestUsingMaxHeap(node, 1));
  }

  private static void doTestUsingDFSWithRecursion() {

    TreeNode node = new TreeNode(2);
    node.left = new TreeNode(1);

    Assert.assertEquals(1, kthSmallestUsingRecursiveDFS(node, 1));

    node = new TreeNode(2);
    node.left = new TreeNode(1);
    Assert.assertEquals(2, kthSmallestUsingRecursiveDFS(node, 2));

    node = new TreeNode(3);
    node.left = new TreeNode(1);
    node.right = new TreeNode(4);
    node.left.right = new TreeNode(2);
    Assert.assertEquals(1, kthSmallestUsingRecursiveDFS(node, 1));
  }

  private static void doTestUsingDFSWithIteration() {

    TreeNode node = new TreeNode(2);
    node.left = new TreeNode(1);

    Assert.assertEquals(1, kthSmallestUsingIterativeDFS(node, 1));

    node = new TreeNode(2);
    node.left = new TreeNode(1);
    Assert.assertEquals(2, kthSmallestUsingIterativeDFS(node, 2));

    node = new TreeNode(3);
    node.left = new TreeNode(1);
    node.right = new TreeNode(4);
    node.left.right = new TreeNode(2);
    Assert.assertEquals(1, kthSmallestUsingIterativeDFS(node, 1));
  }

}
