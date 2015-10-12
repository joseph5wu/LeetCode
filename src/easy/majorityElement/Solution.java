package easy.majorityElement;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                result = nums[i];
                count = 1;
            }
            else if(result == nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }

        return result;
    }
}
