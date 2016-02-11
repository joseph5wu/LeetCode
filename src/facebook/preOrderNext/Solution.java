package facebook.preOrderNext;

import java.util.*;
public class Solution {
    private TreeNode root;
    private Stack<TreeNode> stack;

    public Solution(TreeNode root) {
        this.root = root;
        this.stack = new Stack<>();
        this.stack.push(root);
    }

    public TreeNode next() {
        if(stack.isEmpty()) {
            return null;
        }
        else {
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            return node;
        }
    }

    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> preStack = new Stack<>();
        preStack.push(root);
        TreeNode node;
        while(!preStack.isEmpty()) {
            node = preStack.pop();
            sb.append(node.value);
            if(node.right != null) {
                preStack.push(node.right);
            }
            if(node.left != null) {
                preStack.push(node.left);
            }
            if(!preStack.isEmpty()) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        Solution sol = new Solution(root);
        System.out.println(sol.next().toString());
        System.out.println(sol.next().toString());
        System.out.println(sol.next().toString());
        System.out.println(sol.preOrder());
    }

}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
