package facebook.pathSum;

import java.util.*;
public class Solution {
    public int pathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.add(root);
        sumQueue.add(0);
        TreeNode node;
        int temp;
        int sum = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                node = queue.poll();
                temp = sumQueue.poll() + node.value;
                if(node.left == null && node.right == null) {
                    sum += temp;
                }
                else {
                    if(node.left != null) {
                        queue.add(node.left);
                        sumQueue.add(temp);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                        sumQueue.add(temp);
                    }
                }
            }
        }

        return sum;
    }

    private int sum = 0;
    public int pathSum2(TreeNode node) {
        this.sum = 0;
        dfs(node, 0);
        return this.sum;
    }

    private void dfs(TreeNode node, int sum) {
        if(node == null) {
            return;
        }

        sum += node.value;
        if(node.left == null && node.right == null) {
            this.sum += sum;
        }
        else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
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

        Solution sol = new Solution();
        System.out.println(sol.pathSum(root));
        System.out.println(sol.pathSum2(root));
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
