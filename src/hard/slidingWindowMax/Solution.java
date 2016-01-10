package hard.slidingWindowMax;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        int length = nums.length;
        int[] results = new int[length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < length; i++) {
            // remove numbers out of range k
            while(!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // remove smaller numbers in range k which are useless
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // insert current index
            deque.add(i);
            // current head is max
            if(i >= k - 1) {
                results[index++] = nums[deque.peek()];
            }
        }

        return results;
    }
}
