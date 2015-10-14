package easy.binaryTreePaths;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return all root-to-leaf paths.

     For example, given the following binary tree:

     1
     /   \
     2     3
     \
     5
     All root-to-leaf paths are:

     ["1->2->5", "1->3"]
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        treePathsDFS(root, new StringBuilder(), result);
        return result;
    }

    private void treePathsDFS(TreeNode node, StringBuilder path, List<String> result) {
        if(node.left == null && node.right == null) {
            path.append(node.val);
            result.add(path.toString());
            return;
        }

        path.append(node.val);
        path.append("->");
        if(node.left != null) {
            treePathsDFS(node.left, new StringBuilder(path), result);
        }
        if(node.right != null) {
            treePathsDFS(node.right, new StringBuilder(path), result);
        }
    }
}
