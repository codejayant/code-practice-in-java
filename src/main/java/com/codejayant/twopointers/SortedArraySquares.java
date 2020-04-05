package com.codejayant.twopointers;

import java.util.Arrays;

public class SortedArraySquares {

    public static void main(String[] args) {

        int[] arr = new int[]{-2, -1, 0, 2, 3};


        System.out.println(Arrays.toString(makeSquares(arr)));
    }



    private static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        int index = 0;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int startValue = arr[start];
            int startSquare = startValue * startValue;

            int endValue = arr[end];
            int endSquare = endValue * endValue;

            if (startSquare < endSquare) {
                squares[index] = startSquare;
                start++;
            } else {
                squares[index] = endSquare;
                end--;
            }
            index++;
        }
        return squares;
    }

}
