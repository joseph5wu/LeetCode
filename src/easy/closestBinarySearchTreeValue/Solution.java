package easy.closestBinarySearchTreeValue;

import commons.models.TreeNode;

public class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root.val == target
                || (root.val > target && root.left == null)
                || (root.val < target && root.right == null)
                || (root.left == null && root.right == null)) {
            return root.val;
        }
        int closest = 0;
        if(root.val > target) {
            closest = closestValue(root.left, target);
        }
        else {
            closest = closestValue(root.right, target);
        }

        return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
    }
}
