package medium.binarySearchTreeIterator;

import commons.models.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> tree = null;

    public BSTIterator(TreeNode root) {
        tree = new Stack<>();
        while(root != null) {
            tree.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !tree.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = tree.pop();
        int result = node.val;
        if(node.right != null) {
            node = node.right;
            while(node != null) {
                tree.push(node);
                node = node.left;
            }
        }
        return result;
    }
}
