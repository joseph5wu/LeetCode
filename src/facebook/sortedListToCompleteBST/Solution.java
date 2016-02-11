package facebook.sortedListToCompleteBST;

import java.util.*;

public class Solution {
    private ListNode node;

    private int getDividePos(int start, int end) {
        int m = end - start + 1;
        int height = (int)Math.ceil(Math.log(m + 1) / Math.log(2));
        if(3 * Math.pow(2, height - 2) - 1 >= m) {
            return end - (int) Math.pow(2, height - 2) + 1;
        }
        else {
            return start + (int) Math.pow(2, height - 1) - 1;
        }
    }

    private int getLength(ListNode node) {
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public TreeNode convert(ListNode head) {
        if(head == null) {
            return null;
        }

        this.node = head;
        int length = getLength(head);
        return convert(0, length - 1);
    }

    private TreeNode convert(int start, int end) {
        if(start > end) {
            return null;
        }

        int rootIndex = getDividePos(start, end);
        TreeNode left = convert(start, rootIndex - 1);
        TreeNode root = new TreeNode(node.value);
        node = node.next;
        TreeNode right = convert(rootIndex + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    private String inorder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                sb.append(node.value).append("->");
                node = node.right;
            }
        }

        return sb.substring(0, sb.length() - 2);
    }

    public void levelorder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                node = queue.poll();
                System.out.print(node.value + " ");
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    private TreeNode prev;
    public boolean isBST(TreeNode node) {
        prev = null;
        return helper(node);
    }

    private boolean helper(TreeNode node) {
        if(node == null) {
            return true;
        }

        if(!helper(node.left)) {
            return false;
        }
        if(prev != null && prev.value >= node.value) {
            return false;
        }
        prev = node;
        return helper(node.right);
    }




    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        for(int i = 1; i <= 20; i++) {
            ListNode node = new ListNode(i);
            prev.next = node;
            prev = prev.next;
        }

        Solution sol = new Solution();
        TreeNode root = sol.convert(dummy.next);
        System.out.println(sol.inorder(root));

        sol.levelorder(root);
        System.out.println(sol.isBST(root));
    }
}

class ListNode {
    int value;
    ListNode next;
    ListNode(int value) {
        this.value = value;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
    }
}
