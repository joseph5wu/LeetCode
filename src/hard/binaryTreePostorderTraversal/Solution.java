package hard.binaryTreePostorderTraversal;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        postorderTraversal1(result, root);

        return result;
    }

    private void postorderTraversal1(List<Integer> result, TreeNode root) {
        Stack<TreeNode> tree = new Stack<>();
        // to mark the prev node in order to avoid repeating the right node again
        TreeNode prev = null;
        TreeNode node = root;
        TreeNode temp = null;
        while(node != null || !tree.isEmpty()) {
            if(node != null) {
                tree.push(node);
                node = node.left;
            }
            else {
                temp = tree.peek();
                if(temp.right != null && temp.right != prev) {
                    node = temp.right;
                }
                else {
                    result.add(temp.val);
                    tree.pop();
                    prev = temp;
                }
            }
        }
    }
}
