package facebook.averageLevelNums;

import java.util.*;

public class Solution {
    // bfs
    public List<Double> averageLevelNums(TreeNode root) {
        List<Double> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            int total = 0;
            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();
                total += node.val;
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            results.add((double) total / levelSize);
        }

        return results;
    }

    public List<Double> averageLevelNums2(TreeNode root) {
        List<Double> results = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        dfs(root, 0, sums, counts);

        int levels = sums.size();
        for(int i = 0; i < levels; i++) {
            if(counts.get(i) != 0) {
                results.add((double) sums.get(i) / counts.get(i));
            }
            else {
                results.add((double) 0);
            }
        }



        return results;
    }

    private void dfs(TreeNode node, int level, List<Integer> sums, List<Integer> counts) {
        if(node == null) {
            return;
        }

        if(sums.size() < level + 1) {
            int i = sums.size();
            while(i++ < level + 1) {
                sums.add(0);
            }
        }
        sums.set(level, sums.get(level) + node.val);
        if(counts.size() < level + 1) {
            int i = counts.size();
            while(i++ < level + 1) {
                counts.add(0);
            }
        }
        counts.set(level, counts.get(level) + 1);

        dfs(node.left, level + 1, sums, counts);
        dfs(node.right, level + 1, sums, counts);
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n3 = new TreeNode(3, null, n5);
        TreeNode n2 = new TreeNode(2, n4, null);
        TreeNode root = new TreeNode(1, n2, n3);

        Solution sol = new Solution();
        List<Double> results = sol.averageLevelNums(root);
        for(double result : results) {
            System.out.print(result + " ");
        }

        System.out.println();
        results = sol.averageLevelNums2(root);
        for(double result : results) {
            System.out.print(result + " ");
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
