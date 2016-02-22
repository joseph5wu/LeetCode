package facebook.longestPath;

public class Solution {
    private static int longest = 0;
    private static String path = null;

    public static String longestPath(TreeNode root) {
        if(root == null) {
            return "";
        }

        helper(root, new StringBuilder(), 0);
        return path;
    }

    private static void helper(TreeNode node, StringBuilder sb, int depth) {
        StringBuilder pathSb = new StringBuilder(sb);
        pathSb.append(node.val);

        if(node.left == null && node.right == null) {
            if(depth + 1 > longest) {
                path = pathSb.toString();
                longest = depth + 1;
            }
            return;
        }

        pathSb.append("->");
        if(node.left != null) {
            helper(node.left, pathSb, depth + 1);
        }
        if(node.right != null) {
            helper(node.right, pathSb, depth + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(longestPath(root));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

