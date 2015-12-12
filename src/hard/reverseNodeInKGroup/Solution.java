package hard.reverseNodeInKGroup;

import commons.models.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if(count == k) {
            ListNode nextHead = reverseKGroup(curr, k);
            ListNode newHead = reverse(head, curr);
            head.next = nextHead;
            return newHead;
        }
        return head;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        if(head == null || head.next == null || head == end || head.next == end) {
            return head;
        }

        ListNode next = head.next;
        ListNode remainHead = reverse(next, end);
        next.next = head;
        head.next = null;
        return remainHead;
    }
}
