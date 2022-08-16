package uk.jlennie.leetcode.Challenges;

import uk.jlennie.leetcode.utils.ListNode;


// Problem: Given two linked lists, merge them into a single, sorted list
// Approach: Principally the same as in a normal merge sort
//      Smallest of the two heads of whats left of the list becomes the next of the tail
//      Once either one of the lists is empty, the other is appended to the tail of the sorted list.
public class MergeTwoSortedLists {
    // Have some random value sit at head, then return head.next to get the sorted list
    // Not the cleanest solution, but it'll do
    ListNode mergedList;
    ListNode mergedTail;
    ListNode nodeInListOne;
    ListNode nodeInListTwo;

    public MergeTwoSortedLists() {
        mergedList = new ListNode();
        mergedTail = mergedList;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        setup(list1, list2);

        consumeWhileBothListsNonEmpty();

        addTailWithOneEmptyList();

        return mergedList.next;
    }

    private void setup(ListNode list1, ListNode list2) {
        nodeInListOne = list1;
        nodeInListTwo = list2;
    }

    private void addTailWithOneEmptyList() {
        if (nodeInListOne == null)
            mergedTail.next = nodeInListTwo;
        else
            mergedTail.next = nodeInListOne;
    }

    private void consumeWhileBothListsNonEmpty() {
        while (bothListsNonEmpty()) {
            if (nodeInListOne.val < nodeInListTwo.val)
                consumeNextListOne();
            else
                consumeNextListTwo();
        }
    }

    private boolean bothListsNonEmpty() {
        return nodeInListOne != null && nodeInListTwo != null;
    }

    private void consumeNextListTwo() {
        nodeInListTwo = consumeNextInListAndReturn(nodeInListTwo);
    }

    private void consumeNextListOne() {
        nodeInListOne = consumeNextInListAndReturn(nodeInListOne);
    }

    private ListNode consumeNextInListAndReturn(ListNode nodeInList) {
        mergedTail.next = nodeInList;
        mergedTail = mergedTail.next;

        return nodeInList.next;
    }
}
