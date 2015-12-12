package medium.kthLargestElementInAnArray;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        return getKth(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    private int getKth(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        while(true) {
            while(nums[left] < pivot && left < right) {
                left++;
            }
            while(nums[right] >= pivot && left < right) {
                right--;
            }
            if(left == right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, left, end);

        if(k == left + 1){
            return pivot;
        }
        else if(k < left + 1) {
            return getKth(nums, k, start, left - 1);
        }
        else {
            return getKth(nums, k, left + 1, end);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        Solution sol = new Solution();
        int i = sol.findKthLargest(nums, 2);
        System.out.print(i);
    }
}
