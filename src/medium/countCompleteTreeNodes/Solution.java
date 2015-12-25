package medium.countCompleteTreeNodes;

import commons.models.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        int count = 0;
        int height = height(root);
        while(root != null) {
            if(height(root.right) == height - 1) {
                count += 1 << height;
                root = root.right;
            }
            else {
                count += 1 << (height - 1);
                root = root.left;
            }
            height--;
        }

        return count;
    }

    private int height(TreeNode node) {
        return node == null ? -1 : 1 + height(node.left);
    }
}
