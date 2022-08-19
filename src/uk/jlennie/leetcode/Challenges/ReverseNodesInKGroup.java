package uk.jlennie.leetcode.Challenges;

import uk.jlennie.leetcode.utils.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (!ListAtLeastLengthK(head, k))
            return head;

        ListNode newHead = reverseK(head, k);

        head.next = reverseKGroup(head.next, k);

        return newHead;
    }

    private static ListNode reverseK(ListNode head, int k) {
        ListNode oldHead;
        ListNode newHead = head;
        ListNode tail = newHead.next;
        newHead.next = null;

        for (int i = 0; i < k - 1; i ++) {
            oldHead = newHead;
            newHead = tail;
            tail = tail.next;

            newHead.next = oldHead;
        }

        head.next = tail;
        return newHead;
    }

    private boolean ListAtLeastLengthK(ListNode head, int k) {
        int i = 0;
        ListNode node = head;

        while (node != null && i < k) {
            node = node.next;
            i ++;
        }

        return i == k;
    }
}
