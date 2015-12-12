package hard.countOfSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private TreeNode root = null;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }

        int[] sums = new int[nums.length];
        Node root = null;
        for(int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, sums, i, 0);
        }

        for(int i : sums){
            results.add(i);
        }
        return results;
    }

    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }

        root = null;
        for(int i = nums.length - 1; i >= 0; i--){
            results.add(0, insert(nums[i]));
        }
        return results;
    }

    private int insert(int num) {
        if(root == null) {
            root = new TreeNode(num);
            return 0;
        }

        TreeNode node = root;
        int count = 0;
        while(node != null) {
            if(num < node.val) {
                node.leftCount++;
                if(node.left == null) {
                    node.left = new TreeNode(num);
                    break;
                }
                node = node.left;
            }
            else if(num > node.val) {
                count += node.leftCount + node.dup;
                if(node.right == null) {
                    node.right = new TreeNode(num);
                    break;
                }
                node = node.right;
            }
            else {
                count += node.leftCount;
                node.dup++;
                break;
            }
        }
        return count;
    }

    private Node insert(int num, Node node, int[] results, int i, int preSum) {
        if(node == null) {
            node = new Node(num, 0);
            results[i] = preSum;
        }
        else if(node.val == num) {
            node.dup++;
            results[i] = preSum + node.sum;
        }
        else if(node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, results, i, preSum);
        }
        else {
            node.right = insert(num, node.right, results, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}

class Node {
    Node left, right;
    int val, sum, dup = 1;

    public Node(int val, int sum) {
        this.val = val;
        this.sum = sum;
    }
}

class TreeNode {
    int val, leftCount = 0, dup = 1;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}
