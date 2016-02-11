package facebook.suffixArray;

import java.util.*;
public class Solution {
    public int[] sort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        // first create suffix arrays by definition
        Suffix[] suffixArrays = new Suffix[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int[] array = new int[nums.length - i];
            for(int j = 0; j < nums.length - i; j++) {
                array[j] = nums[i + j];
            }
            suffixArrays[i] = new Suffix(i, array);
        }

        // sort the suffix array by definition
        Arrays.sort(suffixArrays, new Comparator<Suffix>() {
            public int compare(Suffix s1, Suffix s2) {
                int i = 0;
                while(i < s1.array.length && i < s2.array.length) {
                    if(s1.array[i] != s2.array[i]) {
                        return s1.array[i] - s2.array[i];
                    }
                    i++;
                }
                if(i == s1.array.length) {
                    return -1;
                }
                else {
                    return 1;
                }

            }
        });

        int[] results = new int[nums.length];
        int pos = 0;
        // get the final results from the sorted list
        for(Suffix s : suffixArrays) {
            results[pos++] = s.index;
        }
        return results;
    }

    private int compareArray(int[] array1, int[] array2) {
        int pos = 0;
        while(pos < array1.length && pos < array2.length) {
            if(array1[pos] != array2[pos]) {
                return array1[pos] - array2[pos];
            }
            pos++;
        }
        // if array2 loop finished, means array2 may be array1 sub array
        if(pos == array2.length) {
            return 0;
        }
        return -1;
    }

    private int[] getSuffix(int[] nums, int index) {
        return Arrays.copyOfRange(nums, index, nums.length);
    }

    public boolean search(int[] nums, int[] sub) {
        if(nums == null || nums.length == 0 || sub == null || sub.length == 0) {
            return false;
        }

        // sort the nums by suffix array
        int[] indexArray = sort(nums);
        int left = 0;
        int right = indexArray.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int diff = compareArray(getSuffix(nums, indexArray[mid]), sub);
            if(diff == 0) {
                return true;
            }
            else if(diff < 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 20, 30, 25};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.sort(nums)));
        int[] sub = {25,30};
        System.out.println(sol.search(nums, sub));
    }

}

class Suffix {
    int index;
    int[] array;

    public Suffix(int index, int[] array) {
        this.index = index;
        this.array = array;
    }
}
