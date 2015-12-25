package medium.binaryTreeUpsideDown;

import commons.models.TreeNode;

public class Solution {
    /**
     * recursive
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }

    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        TreeNode prev = null;
        TreeNode right = null;
        TreeNode next = null;
        while(root != null) {
            next = root.left;
            root.left = right;
            right = root.right;
            root.right = prev;
            prev = root;
            root = next;
        }

        return prev;
    }


}
