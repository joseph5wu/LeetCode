package hard.binaryTreeMaxPathSum;

import commons.models.TreeNode;

public class Solution {
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSumDown(root);
        return max;
    }

    private int maxPathSumDown(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSumDown(node.left));
        int right = Math.max(0, maxPathSumDown(node.right));
        max = Math.max(max, left + node.val + right);
        return Math.max(left, right) + node.val;
    }
}
