package uk.jlennie.leetcode.Challenges;

public class RemoveElement {
    int numRemovals;
    int[] nums;
    int val;

    public int removeElement(int[] nums, int val) {
        setup(nums, val);

        return removeAt(0, 0);
    }

    private void setup(int[] nums, int val) {
        numRemovals =  0;
        this.nums = nums;
        this.val = val;
    }

    public int removeAt(int index, int shifts) {
        for (int i = index; i < nums.length - shifts; i ++) {
            shiftDownElements(shifts, i);

            if (ithElementIsBad(i)) {
                moveDownRestOfList(shifts, i);
                return getSizeOfSmallerList();
            }
        }

        return getSizeOfSmallerList();
    }

    private int getSizeOfSmallerList() {
        return nums.length - numRemovals;
    }

    private void moveDownRestOfList(int shifts, int i) {
        numRemovals ++;
        removeAt(i, ++shifts);
    }

    private boolean ithElementIsBad(int i) {
        return nums[i] == val;
    }

    private void shiftDownElements(int shifts, int i) {
        nums[i] = nums[i + shifts];
    }
}
