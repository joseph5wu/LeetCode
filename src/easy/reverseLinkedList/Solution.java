package easy.reverseLinkedList;

import commons.models.ListNode;

/**
 * Reverse a singly linked list.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode temp = null;
        while(n1 != null && n2 != null) {
            temp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = temp;
        }
        head.next = null;

        return n2 == null ? n1 : n2;
    }
}
