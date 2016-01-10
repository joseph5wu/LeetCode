package hard.countOfRangeSum;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        long[] sums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        return countWithMergeSort(sums, 0, sums.length, lower, upper);
    }

    private int countWithMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if(end - start <= 1) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = countWithMergeSort(sums, start, mid, lower, upper)
                + countWithMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for(int i = start, r = 0; i < mid; i++, r++) {
            while(k < end && sums[k] - sums[i] < lower) {
                k++;
            }
            while(j < end && sums[j] - sums[i] <= upper) {
                j++;
            }
            while(t < end && sums[t] < sums[i]) {
                cache[r++] = sums[t++];
            }
            cache[r] = sums[i];
            count += (j - k);
        }

        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 5, -1};
        Solution sol = new Solution();
        System.out.println(sol.countRangeSum(nums, -2, 2));
    }
}
