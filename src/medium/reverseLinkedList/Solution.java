package medium.reverseLinkedList;

import commons.models.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

     For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,

     return 1->4->3->2->5->NULL.

     Note:
     Given m, n satisfy the following condition:
     1 ≤ m ≤ n ≤ length of list.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }

        if(m < 1 || m > n) {
            throw new IllegalArgumentException("Invalid input");
        }
        if(m == n) {
            return head;
        }

        // keep m - 1 node
        ListNode m1Node = null;
        // keep n + 1 node
        ListNode n1Node = null;
        ListNode tmp = head;
        int i = 1;
        while(tmp != null) {
            if(i == m - 1) {
                m1Node = tmp;
            }
            if(i == n) {
                n1Node = tmp.next;
                break;
            }
            tmp = tmp.next;
            i++;
        }

        if(m1Node == null) {
            tmp = head;
        }
        else {
            tmp = m1Node.next;
        }

        ListNode next = tmp.next;
        tmp.next = n1Node;
        int times = n - m;
        while(times > 0) {
            ListNode node = next.next;
            next.next = tmp;
            tmp = next;
            next = node;
            times--;
        }

        if(m1Node != null) {
            m1Node.next = tmp;
            return head;
        }
        else {
            return tmp;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        Solution sol = new Solution();
        ListNode result = sol.reverseBetween(node1, 1, 2);
        while(result != null) {
            System.out.println(result.val + " ");
            result = result.next;
        }
    }
}
