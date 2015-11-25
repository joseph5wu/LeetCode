package hard.closestBinarySearchTreeValue;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode> predecessors = new Stack<TreeNode>();
        Stack<TreeNode> successors = new Stack<TreeNode>();

        TreeNode node = root;
        while(node != null) {
            if(node.val > target) {
                getSuccessor(node.right, successors);
                successors.push(node);
                node = node.left;
            }
            else {
                getPredecessor(node.left, predecessors);
                predecessors.push(node);
                node = node.right;
            }
        }

        while(k > 0 && (!predecessors.isEmpty() || !successors.isEmpty())) {
            if(successors.isEmpty() ||
                    (!predecessors.isEmpty() && target - predecessors.peek().val < successors.peek().val - target)) {
                node = predecessors.pop();
            }
            else {
                node = successors.pop();
            }
            k--;
            results.add(node.val);
        }

        return results;
    }

    private void getPredecessor(TreeNode node, Stack<TreeNode> predecessors) {
        if(node == null) {
            return;
        }

        getPredecessor(node.left, predecessors);
        predecessors.push(node);
        getPredecessor(node.right, predecessors);
    }

    private void getSuccessor(TreeNode node, Stack<TreeNode> successors) {
        if(node == null) {
            return;
        }

        getSuccessor(node.right, successors);
        successors.push(node);
        getSuccessor(node.left, successors);
    }

    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        List<Integer> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        Stack<TreeNode> predecessors = new Stack<TreeNode>();
        Stack<TreeNode> successors = new Stack<TreeNode>();
        initStack(root, target, predecessors, successors);

        while(k-- > 0) {
            if(successors.isEmpty() || (!predecessors.isEmpty() &&
                    target - predecessors.peek().val < successors.peek().val - target)) {
                results.add(predecessors.peek().val);
                getPredicessor(predecessors);
            }
            else {
                results.add(successors.peek().val);
                getSuceesors(successors);
            }
        }

        return results;
    }

    private void initStack(TreeNode node, double target, Stack<TreeNode> predecessors, Stack<TreeNode> successors) {
        while(node != null) {
            if(node.val <= target) {
                predecessors.push(node);
                node = node.right;
            }
            else {
                successors.push(node);
                node = node.left;
            }
        }
    }

    private void getPredicessor(Stack<TreeNode> predecessors) {
        TreeNode node = predecessors.pop();
        if(node.left != null) {
            predecessors.push(node.left);
            while(predecessors.peek().right != null) {
                predecessors.push(predecessors.peek().right);
            }
        }
    }

    private void getSuceesors(Stack<TreeNode> successors) {
        TreeNode node = successors.pop();
        if(node.right != null) {
            successors.push(node.right);
            while(successors.peek().left != null) {
                successors.push(successors.peek().left);
            }
        }
    }
}
