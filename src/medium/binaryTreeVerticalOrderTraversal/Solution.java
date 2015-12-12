package medium.binaryTreeVerticalOrderTraversal;

import commons.models.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.add(root);
        level.add(0);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = level.poll();
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }

            map.get(col).add(node.val);
            if(node.left != null) {
                queue.add(node.left);
                level.add(col - 1);
            }
            if(node.right != null) {
                queue.add(node.right);
                level.add(col + 1);
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int key : map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }

        for(int i = min; i <= max; i++) {
            results.add(map.get(i));
        }
        return results;
    }



    public List<List<Integer>> verticalOrder2(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        // 1. find the range of left bound and right bound
        int[] range = new int[2];
        findRange(root, range, 0);

        // 2. calculate number of columns in the result
        int rootIndex = 0 - range[0];
        int columns = range[1] - range[0] + 1;
        for(int i = 0; i < columns; i++) {
            results.add(new ArrayList<>());
        }

        // 3. fill in vertically in a recursive manner
        fillNode(results, root, rootIndex);

        return results;
    }

    private void fillNode(List<List<Integer>> results, TreeNode node, int index) {
        if(node == null) {
            return;
        }
        results.get(index).add(node.val);
        fillNode(results, node.left, index - 1);
        fillNode(results, node.right, index + 1);
    }

    private void findRange(TreeNode node, int[] range, int position) {
        if(node == null) {
            return;
        }
        if(position < range[0]) {
            range[0] = position;
        }
        if(position > range[1]) {
            range[1] = position;
        }

        findRange(node.left, range, position - 1);
        findRange(node.right, range, position + 1);
    }
}
