package medium.sumRootToLeafNumbers;

import commons.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int x) {
        if(node.left == null && node.right == null) {
            return 10 * x + node.val;
        }

        int result = 0;
        if(node.left != null) {
            result += dfs(node.left, 10 * x + node.val);
        }
        if(node.right != null) {
            result += dfs(node.right, 10 * x + node.val);
        }

        return result;
    }

    public int sumNumbers2(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> numberQueue = new LinkedList<>();
        queue.add(root);
        numberQueue.add(root.val);
        TreeNode node;
        int value;
        int result = 0;
        while(!queue.isEmpty()) {
            node = queue.poll();
            value = numberQueue.poll();
            if(node.left == null && node.right == null) {
                result += value;
            }
            else {
                if(node.left != null) {
                    queue.add(node.left);
                    numberQueue.add(10 * value + node.left.val);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    numberQueue.add(10 * value + node.right.val);
                }
            }
        }

        return result;
    }
}
