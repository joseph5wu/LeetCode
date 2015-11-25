package hard.maximalRectangle;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] height = new int[matrix[0].length];
        int maxArea = 0;

        for(int i = 0; i < matrix.length; i++) {
            resetHeight(matrix, height, i);
            maxArea = Math.max(maxArea, largestHeight(height));
        }

        return maxArea;
    }

    private void resetHeight(char[][] matrix, int[] height, int row) {
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[row][i] == '0') {
                height[i] = 0;
            }
            else {
                height[i] += 1;
            }
        }
    }

    private int largestHeight(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i <= length) {
            int heightI = (i == length ? 0 : height[i]);
            if(stack.isEmpty() || heightI >= height[stack.peek()]) {
                stack.push(i++);
            }
            else {
                int peek = stack.pop();
                maxArea = Math.max(maxArea, height[peek] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
