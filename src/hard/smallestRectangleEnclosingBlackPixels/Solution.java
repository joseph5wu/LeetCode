package hard.smallestRectangleEnclosingBlackPixels;

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }

        int rows = image.length;
        int columns = image[0].length;
        // initialize the boarders
        int[] boarders = new int[]{rows - 1, 0, columns - 1, 0};

        dfs(image, boarders, x, y);
        return (boarders[1] - boarders[0] + 1) * (boarders[3] - boarders[2] + 1);
    }

    private void dfs(char[][] image, int[] boarders, int x, int y) {
        int row = image.length;
        int column = image[0].length;
        if(x < 0 || x > row - 1 || y < 0 || y > column - 1) {
            return;
        }
        if(image[x][y] == '0') {
            return;
        }

        image[x][y] = '0';
        if(x < boarders[0]) {
            boarders[0] = x;
        }
        if(x > boarders[1]) {
            boarders[1] = x;
        }
        if(y < boarders[2]) {
            boarders[2] = y;
        }
        if(y > boarders[3]) {
            boarders[3] = y;
        }

        dfs(image, boarders, x - 1, y);
        dfs(image, boarders, x, y - 1);
        dfs(image, boarders, x + 1, y);
        dfs(image, boarders, x, y + 1);
    }

    public static void main(String[] args) {
        //char[][] images = {"0010".toCharArray(), "0110".toCharArray(), "0100".toCharArray()};
        char[][] images = {"01".toCharArray()};
        Solution sol = new Solution();
        System.out.println(sol.minArea(images, 0, 1));
    }
}
