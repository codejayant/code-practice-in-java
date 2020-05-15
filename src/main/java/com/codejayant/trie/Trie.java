package com.codejayant.trie;

import com.codejayant.utils.TrieNode;
import org.junit.Assert;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * @see <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">LeetCode Problem</a>
 * @see <a href="https://leetcode.com/articles/implement-trie-prefix-tree/">LeetCode Article</a>
 */
public class Trie {

    private TrieNode root;

    private Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * Time complexity : O(m)
     * Space complexity : O(m)
     *
     * @param word string
     */
    private void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /**
     * search a prefix or whole key in trie and returns the node where search ends.
     *
     * @param word string
     * @return node where search ends or null if it is mismatch
     */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            if (node.containsKey(currLetter)) {
                node = node.get(currLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Search for the word in the trie.
     * Time complexity : O(m)
     * Space complexity : O(1)
     *
     * @param word string
     * @return true if the word is in the trie
     */
    private boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Search if there is any word in the trie that starts with the given prefix.
     * Time complexity : O(m)
     * Space complexity : O(1)
     *
     * @param prefix string to search as prefix
     * @return true if prefix available
     */
    private boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        doTest();
    }

    private static void doTest() {
        Trie trie = new Trie();

        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.startsWith("app"));
        Assert.assertTrue(trie.startsWith("ap"));
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));
    }

}
