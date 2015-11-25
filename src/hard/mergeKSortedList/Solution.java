package hard.mergeKSortedList;

import commons.models.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2) {
                return Integer.compare(n1.val, n2.val);
            }
        });

        // insert all nodes into the heap
        for(ListNode node : lists) {
            if(node != null) {
                heap.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode node = head;
        ListNode temp = null;
        while(!heap.isEmpty()) {
            temp = heap.poll();
            node.next = temp;
            if(temp.next != null) {
                heap.add(temp.next);
            }
            node = node.next;
        }

        return head.next;
    }

}
