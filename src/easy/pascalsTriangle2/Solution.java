package easy.pascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex < 0) {
            return result;
        }

        result.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j)+ result.get(j + 1));
            }
            result.add(1);
        }

        return result;
    }
}
