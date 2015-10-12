package easy.binaryTreeLevelOrderTraversal2;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

     For example:
     Given binary tree {3,9,20,#,#,15,7},
     3
     / \
     9  20
     /  \
     15   7
     return its bottom-up level order traversal as:
     [
     [15,7],
     [9,20],
     [3]
     ]
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root) {
            return result;
        }

        List<TreeNode> nodeQueue = new ArrayList<>();
        TreeNode node = null;
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> currentList = new ArrayList<>(size);
            for(int i = 0; i < size; i++) {
                node = nodeQueue.get(i);
                currentList.add(node.val);
                if(null != node.left) {
                    nodeQueue.add(node.left);
                }
                if (null != node.right) {
                    nodeQueue.add(node.right);
                }
            }

            // 将当前的List放在最终结果的最前面从而实现倒序
            result.add(0, currentList);
            // 删除已经处理过的节点
            nodeQueue = nodeQueue.subList(size, nodeQueue.size());
        }

        return result;

    }
}
