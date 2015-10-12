package easy.intersectionOfTwoLinkedList;

import commons.models.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(nodeA != null) {
            lengthA++;
            nodeA = nodeA.next;
        }
        while(nodeB != null) {
            lengthB++;
            nodeB = nodeB.next;
        }

        int diff = Math.abs(lengthA - lengthB);
        nodeA = headA;
        nodeB = headB;
        if(lengthA > lengthB) {
            while(diff-- > 0) {
                nodeA = nodeA.next;
            }
        }
        else {
            while (diff-- > 0) {
                nodeB = nodeB.next;
            }
        }

        while (nodeA != null && nodeB != null) {
            if(nodeA.val == nodeB.val) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        Solution sol = new Solution();
        ListNode inter = sol.getIntersectionNode(node1, node2);
        if(inter != null) {
            System.out.println(inter.val);
        }
        else {
            System.out.println("No intersection");
        }
    }
}
