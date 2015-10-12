package easy.mergeTwoSortedLists;

import commons.models.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        else if(l1 == null) {
            return l2;
        }
        else if(l2 == null) {
            return l1;
        }
        else {
            ListNode node1 = l1;
            ListNode node2 = l2;
            ListNode helper = new ListNode(0);
            ListNode temp = helper;
            while(node1 != null && node2 != null) {
                if(node1.val <= node2.val) {
                    temp.next = node1;
                    node1 = node1.next;
                }
                else {
                    temp.next = node2;
                    node2 = node2.next;
                }

                temp = temp.next;
            }

            if(node1 != null) {
                temp.next = node1;
            }
            if(node2 != null) {
                temp.next = node2;
            }

            return helper.next;
        }
    }
}
