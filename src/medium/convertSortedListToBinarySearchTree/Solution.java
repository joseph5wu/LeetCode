package medium.convertSortedListToBinarySearchTree;

import commons.models.ListNode;
import commons.models.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution {
    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        int length = getLength(head);
        node = head;
        return sortedListToBST(0, length - 1);
    }

    private int getLength(ListNode head) {
        ListNode tmp = head;
        int length = 0;
        while(tmp != null) {
            length++;
            tmp = tmp.next;
        }

        return length;
    }

    private TreeNode sortedListToBST(int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode midNode = new TreeNode(node.val);
        node = node.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        midNode.left = left;
        midNode.right = right;
        return midNode;
    }
}
