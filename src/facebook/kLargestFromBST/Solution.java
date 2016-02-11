package facebook.kLargestFromBST;

import java.util.*;

public class Solution {
    public List<Integer> kLargest2(TreeNode root, int k) {
        List<Integer> results = new ArrayList<>();
        if(root == null || k <= 0) {
            return results;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.right;
            }
            else {
                node = stack.pop();
                if(results.size() >= k) {
                    return results;
                }
                results.add(node.val);
                node = node.left;
            }
        }

        return results;
    }


    public List<Integer> kLargest(TreeNode root, int k) {
        List<Integer> results = new ArrayList<>();
        if(root == null || k <= 0) {
            return results;
        }

        dfs(root, k, results);
        return results;
    }

    private void dfs(TreeNode node, int k, List<Integer> results) {
        if(node.right != null) {
            dfs(node.right, k, results);
        }

        // check how many int in the results
        if(results.size() >= k) {
            return;
        }
        results.add(node.val);

        if(node.left != null) {
            dfs(node.left, k, results);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        node5.right = node6;

        Solution sol = new Solution();
        List<Integer> results = sol.kLargest2(root, 3);
        for(int result : results) {
            System.out.println(result);
        }
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
