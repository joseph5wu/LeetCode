package medium.singleNumber;


public class Solution {
    /**
     *
     * Given an array of integers, every element appears twice except for one. Find that single one.

         Note:
         Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    /**
     * Given an array of integers, every element appears three times except for one. Find that single one.

         Note:
         Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int[] bits = new int[32];
        int mask = 1;
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 32; j++) {
                temp = nums[i] >> j;
                if(temp == 0) {
                    break;
                }
                bits[j] += temp & mask;
            }
        }

        int times = 0;
        int target = 0;
        for(int i = 0; i < 32; i++) {
            times = bits[i] % 3 > 0 ? 1 : 0;
            target += (times << i);
        }

        return target;
    }

    public int[] singleNumber3(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int xor = nums[0];
        for(int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        // find the first 1 index
        int mask = 1;
        while((xor & mask) == 0) {
            mask = mask << 1;
        }

        int xor1 = 0;
        int xor2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & mask) == 0) {
                xor1 ^= nums[i];
            }
            else {
                xor2 ^= nums[i];
            }
        }

        return new int[]{xor1, xor2};
    }
}
