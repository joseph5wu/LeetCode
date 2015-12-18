package medium.verifyPreorderSequenceInBinarySearchTree;

import java.util.Stack;

public class Solution {
    /**
     * O(N) time & O(N) space
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int num : preorder) {
            if(num < low) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() < num) {
                low = stack.pop();
            }

            stack.push(num);
        }

        return true;
    }

    /**
     * O(N) time and O(1) space
     * @param preorder
     * @return
     */
    public boolean verifyPreorder2(int[] preorder) {
        if(preorder == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int min = Integer.MIN_VALUE;
        int i = -1;
        for(int num : preorder) {
            if(num < min) {
                return false;
            }
            while(i >= 0 && num > preorder[i]) {
                min = preorder[i--];
            }
            preorder[++i] = num;
        }

        return true;
    }
}
