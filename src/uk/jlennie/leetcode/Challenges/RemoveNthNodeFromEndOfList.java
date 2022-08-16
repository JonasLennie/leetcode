package uk.jlennie.leetcode.Challenges;

import uk.jlennie.leetcode.utils.ListNode;

public class RemoveNthNodeFromEndOfList {
    private ListNode head;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.head = head;
        int pos = getPos(n);

        if (pos == 0)
            return head.next;

        removeNodeAtPos(pos);
        return head;
    }

    private int getPos(int n) {
        int length = getLength();
        return length - n;
    }

    private void removeNodeAtPos(int pos) {
        ListNode node = getNodeAtPos(pos);

        node.next = node.next.next;
    }

    private ListNode getNodeAtPos(int pos) {
        ListNode node = head;

        for (int i = 0; i < pos - 1; i ++)
            node = node.next;

        return node;
    }

    private int getLength() {
        ListNode node = head;
        int length = 1;

        while (node.next != null) {
            length++;
            node = node.next;
        }

        return length;
    }
}
