package medium.serializeAndDeserializeBinaryTree;

import commons.models.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    private static final char SEPARATOR = '#';
    private static final String NULL_MARK = "X";

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        if(sb.charAt(sb.length() - 1) == SEPARATOR) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULL_MARK).append(SEPARATOR);
        }
        else {
            sb.append(root.val).append(SEPARATOR);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(String.valueOf(SEPARATOR))));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if(NULL_MARK.equals(val)) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val + " ");
        TreeNode node = null;
        while(!queue.isEmpty()) {
            node = queue.poll();
            if(node.left == null) {
                sb.append("null ");
            }
            else {
                sb.append(node.left.val + " ");
                queue.add(node.left);
            }

            if(node.right == null) {
                sb.append("null ");
            }
            else {
                sb.append(node.right.val + " ");
                queue.add(node.right);
            }
        }

        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }

        String[] nodes = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.add(root);
        int i = 1;
        TreeNode node = null;
        while(!queue.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            while(!queue.isEmpty()) {
                node = queue.poll();
                if(!nodes[i].equals("null")) {
                    node.left = new TreeNode(Integer.valueOf(nodes[i]));
                    temp.add(node.left);
                }
                i++;
                if(!nodes[i].equals("null")) {
                    node.right = new TreeNode(Integer.valueOf(nodes[i]));
                    temp.add(node.right);
                }
                i++;
            }
            queue = temp;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        Codec sol = new Codec();
        System.out.println(sol.serialize(root));
        System.out.println(sol.serialize2(root));
    }
}
