package amazon;

import commons.models.TreeNode;

public class TreeAmplitude {
    public int solution(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int max, int min) {
        if(node == null) {
            return max - min;
        }

        if(node.val > max) {
            max = node.val;
        }
        if(node.val < min) {
            min = node.val;
        }

        return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
    }
}
