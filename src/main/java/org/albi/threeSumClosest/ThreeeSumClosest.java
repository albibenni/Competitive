package org.albi.threeSumClosest;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.
 */
public class ThreeeSumClosest {
    public int threeSumClosestM(int[] nums, int target) {
        int currentClosestSum = 0;
        int targetDiff = target;
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 1;
            for (int j = nums.length-1; j > i; j--) {
                int sumOfThree = getSumOfThree(nums[i], nums[j], nums[k]);
                int diffAbs = Math.abs(sumOfThree - target);
                if (diffAbs < targetDiff) targetDiff = diffAbs;
                k++;
            }
        }

        return currentClosestSum;
    }

    private int getSumOfThree(int num, int num1, int num2) {
        return num + num1 + num2;
    }
    public int threeSumClosest(int[] nums, int target) {
        int minDif = target;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int start = i + 1, end = nums.length - 1; start < end; ) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < minDif) {
                    minDif = Math.abs(sum - target);
                    result = sum;
                }
                if (sum > target)
                    end--;
                else {
                    start++;
                }

            }
        }
        return result;
    }
}
