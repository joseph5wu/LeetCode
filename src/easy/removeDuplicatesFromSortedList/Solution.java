package easy.removeDuplicatesFromSortedList;

import commons.models.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head;
        while(tmp != null && tmp.next != null) {
            if(tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            }
            else {
                tmp = tmp.next;
            }
        }

        return head;
    }
}
