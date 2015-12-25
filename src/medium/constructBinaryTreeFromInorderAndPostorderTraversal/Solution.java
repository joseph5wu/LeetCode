package medium.constructBinaryTreeFromInorderAndPostorderTraversal;

import commons.models.TreeNode;

public class Solution {
    private int inorderIndex;
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorderIndex = inorder.length - 1;
        this.postorderIndex = postorder.length - 1;
        return buildTree(inorder, postorder, null);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode node) {
        if(postorderIndex < 0) {
            return null;
        }

        // create root node
        TreeNode root = new TreeNode(postorder[postorderIndex--]);

        // if right node exists, create right subtree
        if(inorder[inorderIndex] != root.val) {
            root.right = buildTree(inorder, postorder, root);
        }

        inorderIndex--;

        // if left node exists, create left subtree
        if(node == null || inorder[inorderIndex] != node.val) {
            root.left = buildTree(inorder, postorder, node);
        }

        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        return buildTree(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int postIndex, int inStart, int inEnd) {
        if(inStart > inEnd || postIndex < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIndex]);
        // find root in inorder
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        root.left = buildTree(inorder, postorder, postIndex - (inEnd - inIndex) - 1, inStart, inIndex - 1);
        root.right = buildTree(inorder, postorder, postIndex - 1, inIndex + 1, inEnd);
        return root;
    }
}
