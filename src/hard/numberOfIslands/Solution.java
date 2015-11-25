package hard.numberOfIslands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> results = new ArrayList<>();
        if(m <= 0 || n <= 0 || positions == null || positions.length == 0) {
            return results;
        }

        int count = 0;
        int[] islands = new int[m * n];
        Arrays.fill(islands, -1);

        for(int[] position : positions) {
            int root = n * position[0] + position[1];
            // mark islands flag to its own index
            islands[root] = root;
            count++;

            for(int[] dir : dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                int index = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || islands[index] == -1) {
                    continue;
                }

                // get root index
                int rootIndex = findIslandRootIndex(islands, index);
                // merge another island into the new one
                if(rootIndex != root) {
                    islands[rootIndex] = root;
                    count--;
                }
            }
            results.add(count);
        }

        return results;
    }

    private int findIslandRootIndex(int[] islands, int index) {
        while(index != islands[index]) {
            index = islands[index];
        }

        return index;
    }
}
