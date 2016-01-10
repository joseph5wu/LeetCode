package hard.shortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        // bfs each building and set the shortest distance
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] distances = new int[rows][columns];
        int[][] counts = new int[rows][columns];
        int buildingCount = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 1) {
                    buildingCount++;
                    bfs(grid, distances, counts, i, j);
                }
            }
        }

        int shortestDistance = Integer.MAX_VALUE;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 0 && distances[i][j] != 0 && counts[i][j] == buildingCount) {
                    shortestDistance = Math.min(shortestDistance, distances[i][j]);
                }
            }
        }

        return shortestDistance < Integer.MAX_VALUE ? shortestDistance : -1;
    }

    private void bfs(int[][] grid, int[][] distances, int[][] counts, int row, int column) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, column});
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] block = queue.poll();
                for(int j = 0; j < DIRECTIONS.length; j++) {
                    int x = block[0] + DIRECTIONS[j][0];
                    int y = block[1] + DIRECTIONS[j][1];
                    if(x >= 0 && x < rows && y >= 0 && y < columns && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        distances[x][y] += level;
                        counts[x][y]++;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        Solution sol = new Solution();
        System.out.println(sol.shortestDistance(buildings));
    }
}
