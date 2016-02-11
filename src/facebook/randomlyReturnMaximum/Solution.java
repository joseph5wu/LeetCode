package facebook.randomlyReturnMaximum;

import java.util.Random;

public class Solution {
    public int randomMaximumIndex(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        Random rand = new Random();

        int max = 0;
        int maxCount = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxCount = 1;
                index = i;
            }
            else if(nums[i] == max) {
                maxCount++;
                int randVal = rand.nextInt(maxCount);
                if(randVal < 1) {
                    index = i;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,4,5,3,5};

        int count4 = 0, count6 = 0;
        for(int i = 0; i<10000; i++) {
            int res = sol.randomMaximumIndex(nums);
            if(res == 4) {
                count4 ++;
            }
            if(res == 6) {
                count6 ++;
            }
        }

        System.out.println(count4 + " " + count6);
    }

}
