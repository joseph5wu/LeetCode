package easy.maximumDepthOfBinaryTree;

import commons.models.TreeNode;
/**
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        else {
            return getDepth(root, 1);
        }
    }

    private int getDepth(TreeNode node, int depth) {
        if(null == node) {
            return -1;
        }
        else if (null == node.left && null == node.right) {
            return depth;
        }
        else {
            return Math.max(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1));
        }
    }


}
