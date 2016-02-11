package microsoft;

import commons.models.Point;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private static final int[][] DIRS = new int[][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};
    private int minStep = Integer.MAX_VALUE;
    private List<Point> minPath = null;
    private List<List<Point>> paths = new ArrayList<>();

    public List<Point> solution(int[][] maze, int startX, int startY, int endX, int endY) {
        List<Point> path = new ArrayList<Point>();
        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return path;
        }
        int rows = maze.length;
        int columns = maze[0].length;
        if(startX < 0 || startX >= rows || startY < 0 || startY >= columns) {
            return path;
        }
        if(endX < 0 || endX >= rows || endY < 0 || endY >= columns) {
            return path;
        }

        dfs(maze, startX, startY, endX, endY, new ArrayList<Point>(), 0);
        return minPath;
    }

    private void dfs(int[][] maze, int x, int y, int endX, int endY, List<Point> path, int steps) {
        if(x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return;
        }
        if(maze[x][y] == 1) {
            return;
        }
        if(x == endX && y == endY) {
            steps++;
            List<Point> newPath = new ArrayList<>(path);
            newPath.add(new Point(x, y));
            if(steps < minStep) {
                minStep = steps;
                minPath = newPath;
            }
            paths.add(newPath);
            return;
        }

        maze[x][y] = 1;
        path.add(new Point(x, y));
        for(int[] dir : DIRS) {
            dfs(maze, x + dir[0], y + dir[1], endX, endY, path, steps + 1);
        }
        maze[x][y] = 0;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0,0,0,1,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,0,1}
        };
        Maze sol = new Maze();
        List<Point> path = sol.solution(maze, 0, 0, 2, 3);
        StringBuilder sb = new StringBuilder();
        for(Point p : path) {
            sb.append("(").append(p.x).append(", ").append(p.y).append(")->");
        }
        System.out.println(sb.toString());

        for(List<Point> path1 : sol.paths) {
            sb = new StringBuilder();
            for(Point p : path1) {
                sb.append("(").append(p.x).append(", ").append(p.y).append(")->");
            }
            System.out.println(sb.toString());
        }

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
