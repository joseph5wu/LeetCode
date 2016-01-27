package amazon;

import commons.models.TreeNode;

public class SubTree {
    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        if(node2 == null) {
            return true;
        }
        if(node1 == null) {
            return false;
        }

        return isSameTree(node1, node2) || isSubTree(node1.left, node2) || isSubTree(node1.right, node2);
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

}
