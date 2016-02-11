package facebook.mazeSolution;

import java.util.*;
public class Solution {
    public List<Point> findShortest(int[][] maze) {
        List<Point> results = new ArrayList<>();
        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return results;
        }

        if(maze[0][0] == 1 || maze[maze.length - 1][maze[0].length - 1] == 1) {
            return results;
        }

        findShortest(maze, 0, 0, results, new ArrayList<>());
        return results;
    }

    private void findShortest(int[][] maze, int x, int y, List<Point> results, List<Point> path) {
        if(x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return;
        }
        if(x == maze.length - 1 && y == maze[0].length - 1) {
            // check whether need to update the results
            if(results.isEmpty() || results.size() > path.size() + 1) {
                results.clear();
                for(Point p : path) {
                    results.add(p);
                }
                results.add(new Point(x, y));
            }
            return;
        }

        if(maze[x][y] == 1) {
            return;
        }

        maze[x][y] = 1;
        path.add(new Point(x, y));
        // find 4 dir
        findShortest(maze, x, y + 1, results, path);
        findShortest(maze, x + 1, y, results, path);
        findShortest(maze, x, y - 1, results, path);
        findShortest(maze, x - 1, y, results, path);

        maze[x][y] = 0;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 1},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        Solution sol = new Solution();
        List<Point> result = sol.findShortest(maze);
        for(Point p : result) {
            System.out.print(p.toString() + "->");
        }
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
