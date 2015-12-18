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

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        TreeNode node = root;
        while(node.val < min || node.val > max) {
            if(node.val < min) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }

        return node;
    }
}
