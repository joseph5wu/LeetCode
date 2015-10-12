package easy.binaryTreeLevelOrderTraversal;

import commons.models.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

     For example:
     Given binary tree {3,9,20,#,#,15,7},
     3
     / \
     9  20
     /  \
     15   7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(null == root) {
            return result;
        }

        TreeNode node = null;
        List<TreeNode> nodeQueue = new ArrayList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> currentList = new ArrayList<>(size);
            for(int i = 0; i < size; i++) {
                node = nodeQueue.get(i);
                currentList.add(node.val);
                if(node.left != null) {
                    nodeQueue.add(node.left);
                }
                if(node.right != null) {
                    nodeQueue.add(node.right);
                }
            }

            result.add(currentList);
            // 将已经处理过的node从queue中删除
            nodeQueue = nodeQueue.subList(size, nodeQueue.size());
        }

        return result;
    }
}
