package Challenges;

import java.util.*;

public class ThreeSum {
    // Problem: Given an array, get all triples that sum to zero
    // Brute Force: Calculate sum of all possible triples; O(n^3)
    // General Approach: Given a, find b, c s.t. b + c = - a; if sorted, then this takes O(n) per search.
    //      N searches, plus sorting then gives runtime of n^2 + nlog(n) => O(n^2)

    // Issues:
    //      Details of finding b, c s.t. b + c = - a in O(n)
    //      Do not want duplicate triples
    //      Resulting triples ought to be in orthogonal Order

    // Optimisations:
    //      Fix one value, say a
    //      Assume a <= b <= c and array is sorted
    //      if a at nums[i] suppose b at nums[i + 1] and c at nums[len(nums) - 1]
    //      try possible values of b & c until they cross over
    //      Use a set to store this data (no duplicate inserts)

    int[] nums;
    Set<List<Integer>> triples;
    int i;
    int j;
    int k;

    public List<List<Integer>> threeSum(int[] nums) {
        setup(nums);

        findTriples(nums);

        return new ArrayList<>(triples);
    }

    private void findTriples(int[] nums) {
        for (i = 0; i < nums.length - 2; i ++)
            findTriplesStartingWithI(nums);
    }

    private void findTriplesStartingWithI(int[] nums) {
        j = i + 1;
        k = nums.length - 1;
        while (j < k)
            evaluateValuesOfIJK();
    }

    private void evaluateValuesOfIJK() {
        int sum = calculateSum();
        if (sum > 0)
            k --;
        else if (sum < 0)
            j ++;
        else
            addNewTripleAndProgress();
    }

    private int calculateSum() {
        return nums[i] + nums[j] + nums[k];
    }

    private void addNewTripleAndProgress() {
        triples.add(generateNewTriple());

        k --;
        j ++;
    }

    private void setup(int[] nums) {
        this.nums = nums;

        Arrays.sort(nums);

        triples = new HashSet<>();
    }

    private List<Integer> generateNewTriple() {
        List<Integer> triple = new ArrayList<>();
        triple.add(nums[i]);
        triple.add(nums[j]);
        triple.add(nums[k]);
        return triple;
    }
}
