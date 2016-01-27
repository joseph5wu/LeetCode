package amazon;

public class Maze {
    private final static int[][] DIRS = new int[][]{
            {0,1}, {1,0}, {0,-1}, {-1,0}
    };
    public boolean solution(int[][] maze) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        return dfs(maze, 0, 0);
    }

    private boolean dfs(int[][] maze, int x, int y) {
        if(x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return false;
        }
        if(maze[x][y] == 9) {
            return true;
        }
        if(maze[x][y] != 0) {
            return false;
        }

        maze[x][y] = 1;
        for(int[] dir : DIRS) {
            if(dfs(maze, x + dir[0], y + dir[1])) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0,0,0,1,0},
                {0,0,1,0,0},
                {0,0,1,9,0},
                {0,0,0,0,1}
        };

        Maze sol = new Maze();
        System.out.println(sol.solution(maze));
    }
}
