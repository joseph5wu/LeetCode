package medium.countUnivalueSubtrees;

import commons.models.TreeNode;

public class Solution {

    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        checkUnival(root, count);
        return count[0];
    }

    private boolean checkUnival(TreeNode node, int[] count) {
        if(node == null) {
            return true;
        }

        boolean left = checkUnival(node.left, count);
        boolean right = checkUnival(node.right, count);
        if(left && right) {
            if(node.left != null && node.left.val != node.val) {
                return false;
            }
            if(node.right != null && node.right.val != node.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
