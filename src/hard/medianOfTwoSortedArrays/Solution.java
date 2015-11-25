package hard.medianOfTwoSortedArrays;


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("invalid input");
        }

        int nums1Len = nums1.length, nums2Len = nums2.length;
        int l = (nums1Len + nums2Len + 1) / 2;
        int r = (nums1Len + nums2Len + 2) / 2;
        if(l == r) {
            return findKth(nums1, 0, nums2, 0, l);
        }
        else {
            return (findKth(nums1, 0, nums2, 0, l) + findKth(nums1, 0, nums2, 0, r)) / 2.0;
        }
    }

    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if(start1 > nums1.length - 1) {
            return nums2[start2 + k - 1];
        }
        if(start2 > nums2.length - 1) {
            return nums1[start1 + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if(start1 + k / 2 - 1 < nums1.length) {
            mid1 = nums1[start1 + k / 2 - 1];
        }
        if(start2 + k / 2 - 1 < nums2.length) {
            mid2 = nums2[start2 + k / 2 - 1];
        }

        if(mid1 < mid2) {
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }
        else {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if(nums1 == null  || nums2 == null) {
            throw new IllegalArgumentException("invalid input");
        }

        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int total = nums1Len + nums2Len;
        int i = 0, j = 0;
        boolean even = (total % 2 == 0);
        int times = 1;
        int medianIndex = total / 2 + 1;
        int median = 0;
        int median2 = 0;
        while(times <= medianIndex) {
            if(times == medianIndex - 1) {
                median2 = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
            }
            else if(times == medianIndex) {
                median = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
            }
            if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
            times++;
        }

        if(even) {
            return (median + median2) / 2.0;
        }
        else {
            return median;
        }
    }
}
