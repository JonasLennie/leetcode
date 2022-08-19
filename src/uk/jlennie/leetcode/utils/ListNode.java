package uk.jlennie.leetcode.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        this(0, null);
    }

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printListNode(ListNode head) {
        ListNode node = head;

        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
