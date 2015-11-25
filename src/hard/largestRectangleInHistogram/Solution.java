package hard.largestRectangleInHistogram;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack stack = new Stack<Integer>();
        int maxArea = 0;
        // copy new array and the last element is 0 to get the elements of stack to get the area
        int[] h = Arrays.copyOf(height, height.length + 1);

        int i = 0;
        while(i < h.length) {
            if(stack.isEmpty() || h[(int)stack.peek()] <= h[i]) {
                stack.push(i++);
            }
            else {
                int top = (int)stack.pop();
                maxArea = Math.max(maxArea, h[top] * (stack.isEmpty() ? i : i - (int)stack.peek() - 1));
            }
        }

        return maxArea;
    }
}
