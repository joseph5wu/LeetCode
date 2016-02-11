package facebook.flattenBST;

import java.util.*;
public class BSTSolution {
    public BinaryTreeNode flatten2(TreeNode root) {
        BinaryTreeNode dummy = new BinaryTreeNode(0);
        if(root == null) {
            return null;
        }

        BinaryTreeNode prev = dummy;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                BinaryTreeNode btNode = new BinaryTreeNode(node.val);
                prev.right = btNode;
                btNode.left = prev;
                prev = btNode;
                node = node.right;
            }
        }

        if(dummy.right != null) {
            dummy.right.left = null;
        }
        return dummy.right;
    }

    public BinaryTreeNode flatten(TreeNode root) {
        BinaryTreeNode dummy = new BinaryTreeNode(0);
        dfs(root, dummy);
        if(dummy.right != null) {
            dummy.right.left = null;
        }
        return dummy.right;
    }

    private BinaryTreeNode dfs(TreeNode node, BinaryTreeNode prev) {
        // using inorder to traversal
        if(node == null) {
            return prev;
        }

        // deal with left node
        prev = dfs(node.left, prev);
        BinaryTreeNode btNode = new BinaryTreeNode(node.val);
        prev.right = btNode;
        btNode.left = prev;
        return dfs(node.right, btNode);
    }

    public String serialize(BinaryTreeNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append(node.val).append("#");
            node = node.right;
        }
        return sb.toString();
    }

    public String reverseSerialize(BinaryTreeNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null && node.right != null) {
            node = node.right;
        }
        while(node != null) {
            sb.append(node.val).append("#");
            node = node.left;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        BSTSolution sol = new BSTSolution();
        BinaryTreeNode node = sol.flatten(root);
        System.out.println(sol.serialize(node));
        System.out.println(sol.reverseSerialize(node));
        node = sol.flatten2(root);
        System.out.println(sol.serialize(node));
        System.out.println(sol.reverseSerialize(node));
    }
}

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
    }
}
