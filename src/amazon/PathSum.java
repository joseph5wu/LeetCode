package amazon;

import commons.models.TreeNode;

public class PathSum {
    public int solution(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left != null && root.right == null) {
            return solution(root.left) + root.val;
        }
        else if(root.left == null && root.right != null) {
            return solution(root.right) + root.val;
        }
        else {
            return Math.max(solution(root.left), solution(root.right)) + root.val;
        }
    }
}
