package facebook.inorderNextNode;

public class Solution {
    public TreeNode next(TreeNode p) {
        if(p == null) {
            return null;
        }

        // if p has right node the find the most left node from its right node
        TreeNode node = null;
        if(p.right != null) {
            node = p.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }
        else if(p.parent != null) {
            node = p.parent;
            // if p is its parent's right node, then no next node
            if(node.right == p) {
                return null;
            }
            else {
                return node;
            }
        }
        else {
            return null;
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
    }
}
