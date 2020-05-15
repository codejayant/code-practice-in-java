package com.codejayant.utils;

public class TrieNode {

    // R links to node children
    private TrieNode[] links;
    private boolean isEnd;

    private static final int R = 26;

    public TrieNode()   {
        links = new TrieNode[R];
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public boolean containsKey(char ch) {
        return links[ch -  'a'] != null;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
