package hard.recoverBinarySearchTree;

import commons.models.TreeNode;

public class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorderTraversal(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }

        inorderTraversal(node.left);

        if(first == null && node.val <= prev.val) {
            first = prev;
        }
        if(first != null && node.val <= prev.val) {
            second = node;
        }
        prev = node;

        inorderTraversal(node.right);
    }

    public void recoverTree2(TreeNode root) {
        if(root == null) {
            return;
        }

        TreeNode prev = null;
        TreeNode current = root;
        TreeNode node = null;
        TreeNode first = null;
        TreeNode second = null;
        while(current != null) {
            if(current.left == null) {
                if(prev != null && current.val < prev.val) {
                    if(first == null) {
                        first = prev;
                        second = current;
                    }
                    else {
                        second = current;
                    }
                }
                prev = current;
                current = current.right;
            }
            else {
                node = current.left;
                while(node.right != null && node.right.val != current.val) {
                    node = node.right;
                }

                if(node.right == null) {
                    node.right = current;
                    current = current.left;
                }
                else {
                    if(prev != null && current.val < prev.val) {
                        if(first == null) {
                            first = prev;
                            second = current;
                        }
                        else {
                            second = current;
                        }
                    }
                    node.right = null;
                    prev = current;
                    current = current.right;
                }
            }
        }

        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
