package easy.mergeSortedArray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return;
        }
        else if(m == 0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int mIndex = m - 1;
        int nIndex = n -1;
        int mergeIndex = m + n - 1;
        while(mergeIndex >= 0) {
            if(nIndex < 0 || (mIndex >= 0 && nums1[mIndex] > nums2[nIndex])) {
                nums1[mergeIndex--] = nums1[mIndex--];
            }
            else {
                nums1[mergeIndex--] = nums2[nIndex--];
            }
        }
    }
}
