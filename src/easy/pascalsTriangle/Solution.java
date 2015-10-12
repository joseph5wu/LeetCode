package easy.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

     For example, given numRows = 5,
     Return

     [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     ]
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }

        List<Integer> last = new ArrayList<>();
        last.add(1);
        result.add(last);
        for(int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>(last.size() + 1);
            current.add(1);
            for(int j = 0; j < last.size() - 1; j++) {
                current.add(last.get(j) + last.get(j + 1));
            }
            current.add(1);
            result.add(current);
            last = current;
        }

        return result;
    }
}
