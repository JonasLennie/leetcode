package uk.jlennie.leetcode.Challenges;

import uk.jlennie.leetcode.utils.ListNode;

// Problem: Swap all elements in pairs in a list
//      e.g. [1, 2, 3, 4] => [2, 1, 4, 3]

// General approach is to process each pair individually, and approach the problem recursively.
//  i.e. take first two elements and swap, then process the tail of that list

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode newFirst = secondElementBecomesNewFirst(head);
            ListNode tail = getListTail(head);

            headBecomesElementAfterNewFirst(head, newFirst);

            processTailOfList(head, tail);

            return newFirst;
        } else {
            return head;
        }
    }

    private void processTailOfList(ListNode head, ListNode tail) {
        head.next = swapPairs(tail);
    }

    private static void headBecomesElementAfterNewFirst(ListNode head, ListNode newFirst) {
        newFirst.next = head;
    }

    private static ListNode getListTail(ListNode head) {
        return head.next.next;
    }

    private static ListNode secondElementBecomesNewFirst(ListNode head) {
        return head.next;
    }
}
