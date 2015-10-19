package medium.populatingNextRightPointersInEachNode;

import commons.models.TreeLinkNode;

/**
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    For example,
     Given the following perfect binary tree,
     1
     /  \
     2    3
     / \  / \
     4  5  6  7
     After calling your function, the tree should look like:
     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \  / \
     4->5->6->7 -> NULL
 */
public class Solution {
//    public void connectRecursive(TreeLinkNode root) {
//        if(root == null) {
//            return;
//        }
//
//        if(root.left != null) {
//            root.left.next = root.right;
//        }
//        if(root.right != null && root.next != null) {
//            root.right.next = root.next.left;
//        }
//
//        connectRecursive(root.left);
//        connectRecursive(root.right);
//    }

    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }

        TreeLinkNode current = root;
        // 每一层开始的时候先记录最左侧的子节点
        TreeLinkNode next = null;
        while(current != null) {
            if(next == null) {
                next = current.left;
            }

            if(current.left != null) {
                current.left.next = current.right;
            }
            else {
                break;
            }

            if(current.next != null) {
                current.right.next = current.next.left;
                current = current.next;
            }
            else {
                current = next;
                next = null;
            }
        }
    }
}
