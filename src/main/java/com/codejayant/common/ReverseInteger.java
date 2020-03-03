package com.codejayant.common;

/**
 *  Given a 32-bit signed integer, reverse digits of an integer.
 *
 *  Example 1:
 *
 *   Input: 123
 *   Output: 321
 *
 *  Example 2:
 *
 *   Input: -123
 *   Output: -321
 *
 *  Example 3:
 *
 *   Input: 120
 *   Output: 21
 *
 *  Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 *  Link: https://leetcode.com/problems/reverse-integer/description/
 *
 *
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(123));
        System.out.println(reverse(23));
        System.out.println(reverse(120));
        System.out.println(reverse(-12));
        System.out.println(reverse(-120));
        System.out.println(reverse(109000));
    }

    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // extract the last number
            int pop = x % 10;

            // reducing the number x
            x /= 10;

            // condition to avoid overflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            // logic to reverse the number
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
