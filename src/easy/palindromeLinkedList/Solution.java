package easy.palindromeLinkedList;

import commons.models.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // We can use a fast and slow pointer to get the center of the list,
        // then reverse the second list and compare two sublists. The time is O(n) and space is O(1).
        if(head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;
        p1.next = null;
        ListNode temp = null;
        while(p1 != null && p2 != null) {
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        // compare to first part with second part
        ListNode secondNode = p2 == null ? p1 : p2;
        ListNode firstNode = head;
        while(secondNode != null) {
            if(firstNode.val != secondNode.val) {
                return false;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        return true;
    }
}
