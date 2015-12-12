package medium.wallsAndGates;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int i, int j, int depth) {
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == -1) {
            return;
        }

        if(depth == 0 || depth < rooms[i][j]) {
            rooms[i][j] = depth;

            // left
            bfs(rooms, i, j + 1, depth + 1);
            // right
            bfs(rooms, i, j - 1, depth + 1);
            // down
            bfs(rooms, i + 1, j, depth + 1);
            // up
            bfs(rooms, i - 1, j, depth + 1);
        }
    }
}
