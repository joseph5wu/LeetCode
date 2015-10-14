package easy.firstBadVersion;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
        if(n <= 0) {
            return -1;
        }

        int start = 1;
        int end = n;
        int mid = -1;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if(isBadVersion(start)) {
            return start;
        }
        else if(isBadVersion(end)) {
            return end;
        }
        else {
            return -1;
        }
    }
}
