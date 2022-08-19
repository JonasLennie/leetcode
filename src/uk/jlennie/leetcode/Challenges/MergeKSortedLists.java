package uk.jlennie.leetcode.Challenges;

// Problem: merge k, sorted linked lists into a single list
// Solution: A simple solution will just repeatedly apply the merge to each list
//      This has O(k*n), where n is the length of each list
// Alternative: Will find the minimum head element across all lists and then merge into one list
//      Using the same approach as the traditonal merge. This has O(k*n) roughly as well.
// Will use first solution, as the code is much simpler

import uk.jlennie.leetcode.utils.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode startingList = lists[0];

        for (int i = 1; i < lists.length; i ++) {
            MergeTwoSortedLists m = new MergeTwoSortedLists();
            startingList = m.mergeTwoLists(startingList, lists[i]);
        }

        return startingList;
    }



}
