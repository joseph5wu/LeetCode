package medium.addTwoNumbers;

import commons.models.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(l1 != null || l2 != null || sum != 0) {
            int val1 = (l1 == null ? 0 : l1.val);
            int val2 = (l2 == null ? 0 : l2.val);
            sum += (val1 + val2);

            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = node;
            sum /= 10;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}
