package easy.symmetricTree;

import commons.models.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree is symmetric:

     1
     / \
     2   2
     / \ / \
     3  4 4  3
     But the following is not:
     1
     / \
     2   2
     \   \
     3    3
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        else if(left == null || right == null) {
            return false;
        }
        else {
            if(left.val != right.val) {
                return false;
            }

            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
