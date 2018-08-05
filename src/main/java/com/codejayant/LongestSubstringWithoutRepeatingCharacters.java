package com.codejayant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("pwwkew"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("aab"));
        System.out.println(longestSubstringWithoutRepeatingCharacters(" ").length());
        System.out.println(longestSubstringWithoutRepeatingCharacters("dvdf"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("dvgvddfg"));
    }

    /**
     * TODO to understand
     * @param s string
     * @return length
     */
    private static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    /**
     * wrong implementation
     *
     * @param s string
     * @return substring
     */
    private static String longestSubstringWithoutRepeatingCharacters(String s) {
        if (s.isEmpty()) return "";
        String solutionString = "";
        StringBuilder temp = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {

            if (set.contains(c)) {
                if (temp.length() > solutionString.length()) {
                    solutionString = temp.toString();
                }
                temp = new StringBuilder();
                temp.append(c);
            } else {
                temp.append(c);
                set.add(c);
            }
        }
        if (temp.length() > solutionString.length()) {
            solutionString = temp.toString();
        }
        return solutionString;
    }
}
