package uk.jlennie.leetcode.Challenges;

import java.util.Arrays;

public class ThreeSumClosest {
    // Problem: Find the triple with the sum closest to a given target; return that sum

    // Applying similar theory to uk.jlennie.leetcode.Challenges.ThreeSum solution
    // Brute force possible; complexity of O(n^3)
    // Better solution, by same as uk.jlennie.leetcode.Challenges.ThreeSum, of O(n^2)

    int[] nums;

    int minDelta;
    int minSum;

    int i;
    int j;
    int k;

    public int threeSumClosest(int[] nums, int target) {
        setup(nums);

        findMinSum(nums, target);

        return minSum;
    }

    private void findMinSum(int[] nums, int target) {
        for (i = 0; i < nums.length - 2; i ++)
            closestWithFixedI(nums, target);
    }

    private void closestWithFixedI(int[] nums, int target) {
        j = i + 1;
        k = nums.length - 1;
        while(j < k) {
            evalAndUpdateJK(nums, target);
        }
    }

    private void evalAndUpdateJK(int[] nums, int target) {
        int sum = getSum(nums, i, j, k);
        int delta = getDelta(target, sum);
        int absDelta = getAbs(delta);

        updateMins(sum, absDelta);

        updateJK(delta);
    }

    private void updateJK(int delta) {
        if (delta > 0)
            k --;
        else
            j ++;
    }

    private void updateMins(int sum, int absDelta) {
        if (absDelta < minDelta) {
            minDelta = absDelta;
            minSum = sum;
        }
    }

    private int getAbs(int delta) {
        return Math.abs(delta);
    }

    private int getDelta(int target, int sum) {
        return sum - target;
    }

    private int getSum(int[] nums, int i, int j, int k) {
        return nums[i] + nums[k] + nums[j];
    }

    private void setup(int[] nums) {
        this.nums = nums;

        minDelta = Integer.MAX_VALUE;
        minSum = 0;

        Arrays.sort(this.nums);
    }
}
