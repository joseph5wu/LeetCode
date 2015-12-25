package medium.reorderList;

import commons.models.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        // find the middle node
        ListNode node1 = head;
        ListNode node2 = head;
        while(node1.next != null && node1.next.next != null) {
            node1 = node1.next.next;
            node2 = node2.next;
        }

        // reverse the last half
        ListNode midNode = node2;
        ListNode current = node2.next;
        while(current.next != null) {
            node1 = current.next;
            current.next = node1.next;
            node1.next = midNode.next;
            midNode.next = node1;
        }

        // reorder
        node1 = head;
        node2 = midNode.next;
        while(node1 != midNode) {
            midNode.next = node2.next;
            node2.next = node1.next;
            node1.next = node2;
            node1 = node2.next;
            node2 = midNode.next;
        }
    }
}
