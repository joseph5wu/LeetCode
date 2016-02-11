package amazon.reverseTree;

import java.util.*;
public class Solution {
    public List<TreeNode> reverse(TreeNode root) {
        List<TreeNode> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        helper(root, results);
        return results;
    }

    private void helper(TreeNode node, List<TreeNode> results) {
        if(node.left == null && node.right == null) {
            results.add(node);
            return;
        }

        if(node.left != null) {
            TreeNode left = node.left;
            helper(left, results);
            left.left = node;
            node.left = null;
        }
        if(node.right != null) {
            TreeNode right = node.right;
            helper(right, results);
            right.right = node;
            node.right = null;
        }
    }

    public void serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode temp;
        sb.append(node.value).append('#');

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                temp = queue.poll();
                if(temp.left != null) {
                    sb.append(temp.left.value).append('#');
                    queue.add(temp.left);
                }
                else {
                    sb.append("X#");
                }
                if(temp.right != null) {
                    sb.append(temp.right.value).append('#');
                    queue.add(temp.right);
                }
                else {
                    sb.append("X#");
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node2.right = node3;

        Solution sol = new Solution();
        List<TreeNode> results = sol.reverse(root);
        for(TreeNode result : results) {
            sol.serialize(result);
        }
    }
}



class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}
