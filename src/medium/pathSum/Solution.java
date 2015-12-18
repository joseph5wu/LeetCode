package medium.pathSum;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        dfs(root, sum, results, new ArrayList<>());
        return results;
    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> results, List<Integer> path) {
        if(node == null) {
            return;
        }

        List<Integer> newList = new ArrayList<Integer>(path);
        newList.add(node.val);
        if(node.val == sum && node.left == null && node.right == null) {
            results.add(newList);
            return;
        }

        dfs(node.left, sum - node.val, results, newList);
        dfs(node.right, sum - node.val, results, newList);
    }
}
