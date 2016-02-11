package facebook.checkAscending;
import java.util.*;
public class Solution {
    public boolean check(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int pos = 0;
        while(pos < nums.length - 1 && nums[pos] >= nums[pos + 1]) {
            pos++;
        }
        // if reach the end then return false
        if(pos == nums.length - 2) {
            return false;
        }

        int a = pos;
        int b = pos + 1;
        int least = a;
        for(pos = b + 1; pos < nums.length; pos++) {
            if(nums[pos] > nums[b]) {
                System.out.println(nums[a] + " " + nums[b] + " " + nums[pos]);
                return true;
            }
            if(nums[pos] < nums[least]) {
                least = pos;
            }
            // check whether need to update a and b
            if(nums[a] < nums[pos] && nums[pos] < nums[b]) {
                b = pos;
            }
            else if(nums[least] < nums[pos] && nums[pos] < nums[b]) {
                a = least;
                b = pos;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(100);
        }

        Solution sol = new Solution();
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.check(nums));
    }

}
