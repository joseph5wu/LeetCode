package medium.sortList;

import commons.models.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // use two pointers to break list into two halves
        ListNode fast = head, slow = head, prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow;
        prev.next = null;

        // sort each half
        ListNode left = sortList(head);
        right = sortList(right);
        // merge
        head = merge(left, right);
        return head;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while(left != null && right != null) {
            if(left.val <= right.val) {
                result.next = left;
                result = result.next;
                left = left.next;
            }
            else {
                result.next = right;
                result = result.next;
                right = right.next;
            }
        }

        if(left != null) {
            result.next = left;
        }
        if(right != null) {
            result.next = right;
        }

        return dummy.next;
    }
}
