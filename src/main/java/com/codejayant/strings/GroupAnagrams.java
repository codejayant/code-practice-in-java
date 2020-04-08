package com.codejayant.strings;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * @see <a href="https://leetcode.com/problems/group-anagrams/">LeetCode Problem</a>
 */
public class GroupAnagrams {

    /**
     * This method use counter (since input is lowercase, it will be 26 characters), create a key from that position and then save that with original string as value.
     * T: O(n * k) : n = number of string in array & k is number of character in string
     * S: O(nk)
     *
     * @param stringArray input strings
     * @return grouped anagram
     */
    private static List<List<String>> groupAnagramsWithCounter(String[] stringArray) {
        Map<String, List<String>> map = new HashMap<>();
        int[] counter = new int[26];
        for (String str : stringArray) {

            Arrays.fill(counter, 0);

            for (char c : str.toCharArray()) {
                counter[c - 'a'] = counter[c - 'a'] + 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : counter) {
                sb.append(i);
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * This method sort string character wise, create a key from that and then save that with original string as value.
     * T: O(n * klogk) : n = number of string in array & k is number of character in string
     * S: O(nk)
     *
     * @param stringArray input strings
     * @return grouped anagram
     */
    private static List<List<String>> groupAnagramsWithStringKey(String[] stringArray) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : stringArray) {    // n
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // klog(k)

            String key = Arrays.toString(chars);

            // if (map.get(key) == null) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramsWithCounter(s));
        System.out.println(groupAnagramsWithStringKey(s));
    }

}
