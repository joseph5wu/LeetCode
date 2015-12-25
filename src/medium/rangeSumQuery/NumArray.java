package medium.rangeSumQuery;

import commons.models.SegmentTreeNode;

public class NumArray {
    private SegmentTreeNode root;

    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        else {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if(start == end) {
                node.sum = nums[start];
            }
            else {
                int mid = start + (end - start) / 2;
                node.left = buildTree(nums, start, mid);
                node.right = buildTree(nums, mid + 1, end);
                if(node.left != null) {
                    node.sum += node.left.sum;
                }
                if(node.right != null) {
                    node.sum += node.right.sum;
                }
            }
            return node;
        }
    }

    void update(int i, int val) {
        update(this.root, i, val);
    }

    private void update(SegmentTreeNode root, int pos, int val){
        if(root.start == root.end) {
            root.sum = val;
        }
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if(pos <= mid) {
                update(root.left, pos, val);
            }
            else {
                update(root.right, pos, val);
            }
            root.sum = 0;
            if(root.left != null) {
                root.sum += root.left.sum;
            }
            if(root.right != null) {
                root.sum += root.right.sum;
            }
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(this.root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int start, int end) {
        if(root.start == start && root.end == end) {
            return root.sum;
        }
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if(end <= mid) {
                return sumRange(root.left, start, end);
            }
            else if(start >= mid + 1) {
                return sumRange(root.right, start, end);
            }
            else {
                return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(0, 2));
        array.update(1, 2);
        System.out.println(array.sumRange(0, 2));
    }
}
