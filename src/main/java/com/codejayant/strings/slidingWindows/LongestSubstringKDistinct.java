package com.codejayant.strings.slidingWindows;

import org.junit.Assert;

import java.util.*;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:
 * <p>
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/">LeetCode Problem</a>
 * @see <a href="https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters">Anothet LeetCode Problem</a>
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/YQQwQMWLx80">Educative Problem</a>
 * @see <a href="https://leetcode.com/articles/longest-substring-with-at-most-k-distinct-characte/">LeetCode Article</a>
 */
class LongestSubstringKDistinct {

    public static void main(String[] args) {
        doTest();
    }

    private static void doTest() {
        Assert.assertEquals(4, findLength("araaci", 2));
        Assert.assertEquals(2, findLength("araaci", 1));
        Assert.assertEquals(5, findLength("cbbebi", 3));
    }

    /**
     * find length using sliding window technique + hashMap
     * <p>
     * T: O(N) in the best case of k distinct characters in the string
     * and O(Nk) in the worst case of N distinct characters in the string.
     * <p>
     * Explanation: For the best case when input string contains not more than k distinct characters the answer is yes.
     * It's the only one pass along the string with N characters and the time complexity is O(N).
     * <p>
     * For the worst case when the input string contains n distinct characters, the answer is no.
     * In that case at each step one uses O(k) time to find a minimum value in the hashmap with k elements.
     * So the overall time complexity is O(Nk).
     * </p>
     * S: O(k) : hashmap will have max k key
     *
     * @param str string
     * @param k   k distinct character
     * @return max length of substring with k distinct characters
     */
    private static int findLength(String str, int k) {
        if (str == null || str.isEmpty()) {
            return -1;
        }

        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        while (end < str.length()) {
            // extract the character at end and add to the map
            Character c = str.charAt(end++);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // if map size is greater than k
            // it means more elements are added than intended so need to remove those elements
            while (map.size() > k) {
                Character toRemove = str.charAt(start++);
                map.put(toRemove, map.get(toRemove) - 1);

                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }

            maxLength = Math.max(maxLength, end - start);

        }
        return maxLength;
    }
}
