package easy.removeNthNodeFromEndOfList;

import commons.models.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

     After removing the second node from the end, the linked list becomes 1->2->3->5.
     Note:
     Given n will always be valid.
     Try to do this in one pass.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(i < n) {
            fast = fast.next;
            i++;
            if(fast == null) {
                break;
            }
        }

        // 如果i不等于n，意味着n已经超出Link长度，此时不需要删减，直接返回Head
        if(i != n) {
            return head;
        }
        if(fast == null) {
            return head.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
