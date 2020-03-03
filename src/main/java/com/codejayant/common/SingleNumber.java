package com.codejayant.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Find out single number in an array of duplicate number
 *
 * https://leetcode.com/problems/single-number/description/
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{400,101,2,101,2};
        System.out.println("HashMap Solution: " + singleNumberByHashMap(nums));
        System.out.println("XOR Solution: " + singleNumberByXOR(nums));

    }

    private static int singleNumberByHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i: nums)   {
            if (map.get(i) != null) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }

        return (int) map.keySet().toArray()[0];
    }

    private static int singleNumberByXOR(int[] nums)    {
        int i = 0b00000000;

        for (int j: nums)   {
            i ^= j;
        }
        return i;
    }


}
