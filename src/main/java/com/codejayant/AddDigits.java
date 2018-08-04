package com.codejayant;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * https://leetcode.com/problems/add-digits/description/
 */
public class AddDigits {

    public static void main(String[] args) {
        int num = 88;
        System.out.println(addDigits(num));
    }

    private static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
