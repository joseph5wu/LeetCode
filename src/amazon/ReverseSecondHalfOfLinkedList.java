package amazon;

import commons.models.ListNode;

public class ReverseSecondHalfOfLinkedList {

    public ListNode reverseSecondHalf(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // using slow/fast pointers to locate the middle node
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // start to reverse
        ListNode pre = slow.next;
        ListNode cur = pre.next;
        pre.next = null;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = pre;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;

        ReverseSecondHalfOfLinkedList sol = new ReverseSecondHalfOfLinkedList();
        ListNode temp = sol.reverseSecondHalf(head);
        System.out.println(temp.toString());
    }
}
