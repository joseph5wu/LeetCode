package medium.uniqueBinarySerachTrees;

import commons.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

     For example,
     Given n = 3, there are a total of 5 unique BST's.

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
 */
public class Solution {
    public int numTrees(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        if(n < 2) {
            return 1;
        }

        int[] results = new int[n + 1];
        results[0] = 1;
        results[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= i - 1; j++) {
                results[i] += results[j] * results[i - 1 - j];
            }
        }

        return results[n];
    }

    public List<TreeNode> generateTrees(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<List<TreeNode>> results = new ArrayList<>();
        TreeNode node0 = null;
        List<TreeNode> list0 = new ArrayList<>();
        list0.add(node0);
        results.add(list0);

        TreeNode node1 = new TreeNode(1);
        List<TreeNode> list1 = new ArrayList<>();
        list1.add(node1);
        results.add(list1);

        for(int i = 2; i <= n; i++) {
            List<TreeNode> listi = new ArrayList<>();
            for(int j = 0; j <= (i - 1) / 2; j++) {
                int end = i - 1 - j;
                for(TreeNode left : results.get(j)) {
                    for(TreeNode right : results.get(end)) {
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        listi.add(node);
                        if(j != end) {
                            node = new TreeNode(i);
                            node.left = right;
                            node.right = left;
                            listi.add(node);
                        }
                    }
                }
            }

            results.add(listi);
        }

        return results.get(n);
    }

    public List<TreeNode> generateTreesRecursive(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end) {
            result.add(null);
            return result;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for(TreeNode left : lefts) {
                for(TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }

        return result;
    }
}
