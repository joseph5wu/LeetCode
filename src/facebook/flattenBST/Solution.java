package facebook.flattenBST;

import java.util.*;
public class Solution {
    private static final String DIVIDER = "#";
    private static final String NULL_MARKER = "X";


    public void flatten(TreeNode root) {
        dfs(root, null);
    }

    private TreeNode dfs(TreeNode node, TreeNode prev) {
        if(node == null) {
            return prev;
        }

        prev = dfs(node.left, prev);
        prev = dfs(node.right, prev);
        node.left = prev;
        node.right = null;
        return node;
    }

    public String serialize(TreeNode root) {
        // using bfs to level order traversal
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            return sb.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append(DIVIDER);
        TreeNode node;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                    sb.append(node.left.val).append(DIVIDER);
                }
                else {
                    sb.append(NULL_MARKER).append(DIVIDER);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    sb.append(node.right.val).append(DIVIDER);
                }
                else {
                    sb.append(NULL_MARKER).append(DIVIDER);
                }
            }
        }

        // remove the last divider
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     1
     / \
     2   3
     / \
     4   5
     */
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

        Solution sol = new Solution();
        System.out.println(sol.serialize(root));
        sol.flatten(root);
        System.out.println(sol.serialize(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
