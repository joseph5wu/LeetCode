package medium.rotateList;

import commons.models.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

     For example:
     Given 1->2->3->4->5->NULL and k = 2,
     return 4->5->1->2->3->NULL.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k <= 0) {
            return head;
        }

        // 计算链表长度
        int length = 0;
        ListNode fast = head;
        while(fast != null) {
            length++;
            fast = fast.next;
        }

        k = k % length;
        if(k == 0) {
            return head;
        }

        fast = head;
        ListNode slow = head;
        while(k > 0) {
            fast = fast.next;
            k--;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        Solution sol = new Solution();
        ListNode result = sol.rotateRight(node, 0);
        while(result != null) {
            System.out.println(result.val + " ");
            result = result.next;
        }
    }
}
