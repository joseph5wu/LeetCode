package medium.inorderSuccessorInBST;

import commons.models.TreeNode;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) {
            return null;
        }

        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) {
            return null;
        }

        if(root.val >= p.val) {
            return inorderPredecessor(root.left, p);
        }
        else {
            TreeNode right = inorderPredecessor(root.right, p);
            return right == null ? root : right;
        }
    }
}
