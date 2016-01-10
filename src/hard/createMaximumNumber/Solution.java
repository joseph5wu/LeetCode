package hard.createMaximumNumber;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1 == null && nums2 == null) {
            return null;
        }
        if(nums1 == null) {
            return getMaxSubArray(nums2, k);
        }
        if(nums2 == null) {
            return getMaxSubArray(nums1, k);
        }

        int[] results = new int[k];
        int[] temp = null;
        for(int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
            int[] result1 = getMaxSubArray(nums1, i);
            int[] result2 = getMaxSubArray(nums2, k - i);
            temp = merge(result1, result2, k);
            if(compare(temp, 0, results, 0)) {
                results = temp;
            }
        }
        return results;
    }

    private int[] getMaxSubArray(int[] nums, int k) {
        int[] results = new int[k];
        int len = nums.length;
        for(int i = 0, j = 0; i < len; i++) {
            while(len - i + j > k && j > 0 && results[j - 1] < nums[i]) {
                j--;
            }
            if(j < k) {
                results[j++] = nums[i];
            }
        }
        return results;
    }

    private boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
        for(; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if(nums1[start1] > nums2[start2]) {
                return true;
            }
            else if(nums1[start1] < nums2[start2]) {
                return false;
            }
        }
        return start1 != nums1.length;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0, index = 0;
        int[] results = new int[k];
        while(index1 < nums1.length || index2 < nums2.length) {
            results[index++] = compare(nums1, index1, nums2, index2) ? nums1[index1++] : nums2[index2++];
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{6, 7};
        int[] nums2 = new int[]{6, 0, 4};
        Solution sol = new Solution();
        int[] results = sol.maxNumber(nums1, nums2, 5);
        for(int result : results) {
            System.out.print(result + " ");
        }
    }
}
