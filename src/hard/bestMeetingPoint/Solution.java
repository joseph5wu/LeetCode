package hard.bestMeetingPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        return getDistance(rows) + getDistance(columns);
    }

    private int getDistance(List<Integer> list) {
        int distance = 0;
        // sort the list
        Collections.sort(list);
        int i = 0;
        int j = list.size() - 1;
        while(i < j) {
            distance += (list.get(j--) - list.get(i++));
        }
        return distance;
    }
}
