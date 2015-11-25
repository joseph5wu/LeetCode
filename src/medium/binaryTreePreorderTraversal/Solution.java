package medium.binaryTreePreorderTraversal;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

     For example:
     Given binary tree {1,#,2,3},
     1
     \
     2
     /
     3
     return [1,2,3].

     Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        preOrderTraversalRecursive(root, result);
        return result;
    }

    private void preOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        if(node == null) {
            return;
        }
        result.add(node.val);
        preOrderTraversalRecursive(node.left, result);
        preOrderTraversalRecursive(node.right, result);
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        TreeNode node = root;
        TreeNode prev = null;
        while(node != null) {
            if(node.left != null) {
                prev = node.left;
                // find the predecessor node
                while(prev.right != null && prev.right != node) {
                    prev = prev.right;
                }

                if(prev.right == node) {
                    prev.right = null;
                    node = node.right;
                }
                else {
                    result.add(node.val);
                    prev.right = node;
                    node = node.left;
                }
            }
            else {
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }



}
