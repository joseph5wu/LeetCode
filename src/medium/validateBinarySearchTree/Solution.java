package medium.validateBinarySearchTree;

import commons.models.TreeNode;
import java.util.*;
public class Solution {
    private static TreeNode prev = null;

    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(!isValidBST(root.left)) {
            return false;
        }

        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;

        return isValidBST(root.right);
    }

    public static boolean isValidBST2(TreeNode root) {
        if(root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                if(prev != null && prev.val >= node.val) {
                    return false;
                }
                prev = node;
                node = node.right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        node1.right = node2;
        root.right = node4;
        node4.left = node3;
        node4.right = node6;
        node6.left = node5;
        System.out.println(isValidBST2(root));
    }

}
