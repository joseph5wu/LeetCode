package medium.insertionSortList;

import commons.models.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode node = head, prev = null, next = null;
        while(node != null) {
            prev = dummy;
            next = node.next;
            while(prev.next != null && prev.next.val <= node.val) {
                prev = prev.next;
            }

            node.next = prev.next;
            prev.next = node;
            node = next;
        }

        return dummy.next;
    }
}
