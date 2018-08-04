package com.codejayant;

import java.util.HashMap;
import java.util.Map;

/**
 * Find out single number in an array of triplet number
 *
 * https://leetcode.com/problems/single-number-ii/description/
 */
public class SingleNumber2 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 99};
        System.out.println("HashMap Solution: " + singleNumber2ByHashMap(nums));
        System.out.println("XOR Solution: " + singleNumber2ByXOR(nums));

    }

    private static int singleNumber2ByHashMap(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int n : nums) {
            if (map1.get(n) != null) {
                map1.put(n, map1.get(n) + 1);
                map2.remove(n);
            } else {
                map1.put(n, 1);
                map2.put(n, 1);
            }
        }

        return (int) map2.keySet().toArray()[0];
    }

    private static int singleNumber2ByXOR(int[] nums) {
        //TODO
        return 100000000;

    }

}
