package medium.grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        if(n < 0) {
            return results;
        }

        results.add(0);
        for(int i = 0; i < n; i++) {
            int size = results.size();
            for(int j = size - 1; j >= 0; j--) {
                results.add(size + results.get(j));
            }
        }
        return results;
    }

}
