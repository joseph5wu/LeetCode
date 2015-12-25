package medium.swapNodesInPairs;

import commons.models.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode first = null, second = null;
        while(node.next != null && node.next.next != null) {
            first = node.next;
            second = node.next.next;
            first.next = second.next;
            node.next = second;
            node.next.next = first;
            node = node.next.next;
        }

        return dummy.next;
    }
}
