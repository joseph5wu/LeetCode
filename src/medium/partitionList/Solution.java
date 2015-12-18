package medium.partitionList;

import commons.models.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode node1 = list1, node2 = list2;
        while(head != null) {
            if(head.val < x) {
                node1.next = head;
                node1 = node1.next;
            }
            else{
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
        node1.next = list2.next;
        node2.next = null;
        return list1.next;
    }
}
