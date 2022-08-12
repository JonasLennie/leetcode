package Challenges;

import java.util.*;

public class FourSum {
    Set<List<Integer>> quads;
    int[] nums;
    int i, j, k, l;
    int target;

    public FourSum() {
        i = 0;
        j = 0;
        k = 0;
        l = 0;

        quads = new HashSet<>();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        setup(nums, target);

        setAllValidQuads(nums);

        return quads.stream().toList();
    }

    private void setAllValidQuads(int[] nums) {
        for (i = 0; i < nums.length - 3; i ++)
            checkForValidQuadsWithI(nums);
    }

    private void checkForValidQuadsWithI(int[] nums) {
        for (j = i + 1; j < nums.length - 2; j ++)
            checkForAnyValidQuadsWithIAndJ(nums);
    }

    private void checkForAnyValidQuadsWithIAndJ(int[] nums) {
        setKL(nums);
        while(k < l)
            processValuesOfIJKL(nums);
    }

    private void setKL(int[] nums) {
        k = j + 1;
        l = nums.length - 1;
    }

    private void processValuesOfIJKL(int[] nums) {
        long sum = getSum(nums);
        processSum(sum);
    }

    private long getSum(int[] nums) {
        return (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
    }

    private void processSum(long sum) {
        if (sum > target)
            l --;
        else if (sum < target)
            k ++;
        else
            addNewQuadAndProgress();
    }

    private void addNewQuadAndProgress() {
        quads.add(createQuad());
        l --;
        k ++;
    }

    private List<Integer> createQuad() {
        List<Integer> quad = new ArrayList<>();
        quad.add(nums[i]);
        quad.add(nums[j]);
        quad.add(nums[k]);
        quad.add(nums[l]);
        return quad;
    }

    private void setup(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        Arrays.sort(this.nums);
    }
}
