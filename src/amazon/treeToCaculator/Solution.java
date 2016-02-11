package amazon.treeToCaculator;

public class Solution {
    public static String build(TreeNode root) {
        if(root == null) {
            return "";
        }
        if(root.left == null && root.right == null) {
            return root.str;
        }
        if(root.left == null || root.right == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        if(root.str.equals("*") || root.str.equals("/")) {
            if(root.left.str.equals("+") || root.left.str.equals("-")) {
                result.append("(").append(build(root.left)).append(")");
            }
            else {
                result.append(build(root.left));
            }
            result.append(root.str);
            if(root.right.str.equals("+") || root.right.str.equals("-")) {
                result.append("(").append(build(root.right)).append(")");
            }
            else {
                result.append(build(root.right));
            }
        }
        else if(root.str.equals("+") || root.str.equals("-")) {
            result.append(build(root.left)).append(root.str).append(build(root.right));
        }
        return result.toString();
    }

    public static int calculate(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return Integer.parseInt(root.str);
        }
        if(root.left == null || root.right == null) {
            return 0;
        }

        int left = calculate(root.left);
        int right = calculate(root.right);
        switch(root.str){
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if(right == 0) {
                    return 0;
                }
                return left / right;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("*");
        TreeNode left = new TreeNode("+");
        TreeNode right = new TreeNode("/");
        TreeNode l1 = new TreeNode("10");
        TreeNode l2 = new TreeNode("9");
        TreeNode l3 = new TreeNode("8");
        TreeNode l4 = new TreeNode("2");
        root.left = left;
        root.right = right;
        left.left = l1;
        left.right = l2;
        right.left = l3;
        right.right = l4;
        System.out.println(build(root));
        System.out.println(calculate(root));
    }
}


class TreeNode {
    int value;
    String str;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(String str) {
        this.str = str;
    }
}
