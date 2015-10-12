package easy.minimumDepthOfBinaryTree;

import commons.models.TreeNode;

/**
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        else {
            return getDepth(root, 1);
        }
    }

    private int getDepth(TreeNode node, int depth) {
        if(null == node) {
            return Integer.MAX_VALUE;
        }
        else if(null == node.left && null == node.right) {
            return depth;
        }
        else {
            return Math.min(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1));
        }
    }
}
