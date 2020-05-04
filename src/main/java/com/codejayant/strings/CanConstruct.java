package com.codejayant.strings;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @see <a href="https://leetcode.com/problems/ransom-note/">LeetCode Problem</a>
 */
public class CanConstruct {

    /**
     * Find if all characters present in ransom note come from magazine or not.
     *
     * @param ransomNote ransom note or strings to search if present in dictionary
     * @param magazine magazine or dictionary
     * @return true if magazine includes all ransom note strings, otherwise false
     */
    private static boolean canConstruct(final String ransomNote, final String magazine) {

        // Check for obvious fail case.
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // map to record all characters present in magazine
        Map<Character, Integer> magazineMap = new HashMap<>();

        // record all characters from magazine
        for (Character c: magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        for (Character c1: ransomNote.toCharArray()) {
            Integer i1 = magazineMap.getOrDefault(c1, 0);
            if (i1 == 0) {
                return false;
            }
            magazineMap.put(c1, i1 - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        doTest();
    }

    private static void doTest() {
        Assert.assertFalse(canConstruct("a", "b"));
        Assert.assertFalse(canConstruct("aa", "ab"));
        Assert.assertTrue(canConstruct("aa", "aab"));
    }
}
