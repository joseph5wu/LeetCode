package medium.lowestCommonAncestorOfABinaryTree;

import commons.models.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p) {
            return p;
        }
        if(root == q) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) {
            return null;
        }
        else if(left != null && right == null) {
            return left;
        }
        else if(left == null && right != null) {
            return right;
        }
        else {
            return root;
        }
    }
}
