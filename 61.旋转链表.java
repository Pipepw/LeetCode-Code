/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode secend = head;
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        int index = 0;
        while (secend.next != null) {
            if (index < k) {
                secend = secend.next;
                index++;
            } else {
                first = first.next;
                secend = secend.next;
            }
        }
        ListNode newHead = first.next;
        first.next = null;
        secend.next = head;
        return newHead;
    }
}