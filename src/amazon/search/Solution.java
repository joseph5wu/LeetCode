package amazon.search;

import java.io.*;

public class Solution {
    public int search(int[] nums, int target) {
        // find the smallest point
        int start = 0, end = nums.length - 1;
        int pivot = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
                    pivot = mid;
                    break;
                } else if (nums[mid - 1] < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                break;
            }
        }

        start = 0;
        end = pivot;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        start = pivot;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,1,2,3,4};
        Solution sol = new Solution();
        System.out.println(sol.search(nums, 8));
        System.out.println(sol.search(nums, 3));
        System.out.println(sol.search(nums, 9));
        System.out.println(sol.search(nums, 4));
        System.out.println(sol.search(nums, 1));


    }
}
