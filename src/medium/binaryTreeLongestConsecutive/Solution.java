package medium.binaryTreeLongestConsecutive;

import commons.models.TreeNode;

public class Solution {
    private int max = 1;

    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        this.max = 1;
        recursive(root, 1);
        return this.max;
    }

    private void recursive(TreeNode node, int length) {
        if(node.left != null) {
            if(node.val + 1 == node.left.val) {
                this.max = Math.max(this.max, length + 1);
                recursive(node.left, length + 1);
            }
            else {
                recursive(node.left, 1);
            }
        }
        if(node.right != null) {
            if(node.val + 1 == node.right.val) {
                this.max = Math.max(this.max, length + 1);
                recursive(node.right, length + 1);
            }
            else {
                recursive(node.right, 1);
            }
        }
    }
}
