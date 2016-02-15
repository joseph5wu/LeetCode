package airbnb.findOcean;

import java.util.*;
public class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void findOcean(String[] map, int row, int column) {
        int rows = map.length;
        int columns = map[0].length();
        // conver string array to char[][]
        char[][] newMap = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMap[i][j] = map[i].charAt(j);
            }
        }

        if (newMap[row][column] == 'L') {
            return;
        }


        // using bfs to mark the ocean
        Queue<Integer> queue = new LinkedList<>();
        queue.add(row * columns + column);
        newMap[row][column] = 'O';
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            row = pos / columns;
            column = pos % columns;
            for (int[] dir : DIRS) {
                int newRow = row + dir[0];
                int newColumn = column + dir[1];
                if (newRow < 0 || newRow >= rows || newColumn < 0 || newColumn >= columns || newMap[newRow][newColumn] != 'W') {
                    continue;
                }
                newMap[newRow][newColumn] = 'O';
                queue.add(newRow * columns + newColumn);
            }
        }

        for (int i = 0; i < rows; i++) {
            System.out.println(newMap[i]);
        }
    }

    public static void main(String[] args) {
        String[] map = {"WWWLLLW", "WWLLLWW", "WLLLLWW"};
        findOcean(map, 0, 1);
    }
}
