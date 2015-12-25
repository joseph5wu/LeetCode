package medium.constructBinaryTreeFromPreorderAndInorderTraversal;

import commons.models.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if(preIndex >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        // find root in inorder
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = buildTree(preorder, inorder, preIndex + 1, inStart, inIndex - 1);
        root.right = buildTree(preorder, inorder, preIndex + (inIndex - inStart) + 1, inIndex + 1, inEnd);
        return root;
    }

    private int pInorder;
    private int pPreorder;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.pInorder = 0;
        this.pPreorder = 0;
        return buildTree(preorder, inorder, null);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, TreeNode prev) {
        if(pPreorder >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pPreorder++]);
        // if left node exists, create left subtree
        if(inorder[pInorder] != root.val) {
            root.left = buildTree(preorder, inorder, root);
        }

        pInorder++;
        // if right node exists, create right subtree
        if(prev == null || inorder[pInorder] != prev.val) {
            root.right = buildTree(preorder, inorder, prev);
        }

        return root;
    }
}
