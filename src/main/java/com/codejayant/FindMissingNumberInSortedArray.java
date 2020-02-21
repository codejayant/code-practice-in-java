package com.codejayant;

/**
 * Find the only missing number in a sorted array.
 */
public class FindMissingNumberInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 3};

        System.out.println(findMissing(arr));
    }

    /**
     * Solution using Binary search hence O(log n)
     * @param a array
     * @return missing number
     */
    private static int findMissing(int[] a) {

        int l = 0, r = a.length - 1, mid = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if (a[mid] != mid + 1 && a[mid - 1] == mid) {
                return mid + 1;
            }

            if (a[mid] != mid + 1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;

    }



}
