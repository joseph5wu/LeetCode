package medium.serializeAndDeserializeBinaryTree;

import commons.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

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
}
