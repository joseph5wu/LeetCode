package easy.invertBinaryTree;

import commons.models.TreeNode;

/**
 * Invert a binary tree.

     4
     /   \
     2     7
     / \   / \
     1   3 6   9
     to
     4
     /   \
     7     2
     / \   / \
     9   6 3   1

 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(null == root) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }

        // 左右节点互换
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
