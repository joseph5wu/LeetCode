package medium.binaryTreeInorderTraversal;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

     For example:
     Given binary tree {1,#,2,3},
     1
     \
     2
     /
     3
     return [1,3,2].

     Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        inorderTraversalRecursive(root, result);

        return result;
    }

    private void inorderTraversalRecursive(TreeNode node, List<Integer> result){
        if(node.left != null) {
            inorderTraversalRecursive(node.left, result);
        }

        result.add(node.val);

        if(node.right != null) {
            inorderTraversalRecursive(node.right, result);
        }
    }

}
