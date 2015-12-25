package medium.flattenBinaryTreeToLinkedList;

import commons.models.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        TreeNode temp = null;
        while(root != null) {
            if(root.left != null) {
                temp = root.left;
                while(temp.right != null) {
                    temp = temp.right;
                }

                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    private TreeNode prev = null;
    public void flatten2(TreeNode root) {
        if(root == null) {
            return;
        }

        // first deal with right node
        flatten2(root.right);
        flatten2(root.left);
        root.right = prev;
        root.left = null;
        prev= root;
    }


}
