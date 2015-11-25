package medium.kthSmallestElementInBST;

import commons.models.TreeNode;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0) {
            return Integer.MIN_VALUE;
        }

        Stack<TreeNode> tree = new Stack<>();
        TreeNode node = root;
        TreeNode temp = null;
        int count = 0;
        while(node != null || !tree.isEmpty()) {
            if(node != null) {
                tree.push(node);
                node = node.left;
            }
            else {
                temp = tree.pop();
                if(++count == k) {
                    return temp.val;
                }
                node = temp.right;
            }
        }

        return Integer.MIN_VALUE;
    }
}
