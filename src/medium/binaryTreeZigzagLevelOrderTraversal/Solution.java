package medium.binaryTreeZigzagLevelOrderTraversal;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        boolean fromLeft = true;
        int size = 1;
        while(!queue.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                node = queue.poll();
                if(fromLeft) {
                    currentList.add(node.val);
                }
                else {
                    currentList.add(0, node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            results.add(currentList);
            size = queue.size();
            fromLeft = !fromLeft;
        }

        return results;
    }
}
