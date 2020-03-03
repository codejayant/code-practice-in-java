package com.codejayant.common;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Link: https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
//        System.out.println(maxArea(height));
        System.out.println(maxAreaOptimalSolution(height));
    }

    /**
     * O(n2) solution
     * @param height height array
     * @return max area
     */
    private static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int commonHeight = height[i] < height[j] ? height[i] : height[j];
                int diffIndex = j - i;
                int area = commonHeight * diffIndex;
//                System.out.println(String.format("commonHeight: %s diffIndex: %s area: %s\n", commonHeight, diffIndex, area));
                maxArea = area > maxArea ? area : maxArea;

//                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    /**
     * O(n) solution
     * @param height height array
     * @return max area
     */
    private static int maxAreaOptimalSolution(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

}
