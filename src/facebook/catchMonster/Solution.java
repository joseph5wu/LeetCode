package facebook.catchMonster;

public class Solution {
    public boolean alibaba(int numCaves, int[] strategy) {
        int days = strategy.length;
        boolean[][] res = new boolean[numCaves][days];
        for (int i = 0; i < days; i++) {
            res[strategy[i]][i] = true;
        }


        for (int i = 0; i < numCaves; i++) {
            for (int j = 1; j < days; j++) {
                if (i == numCaves - 1) {
                    res[i][j] = res[i][j] || res[i - 1][j - 1];
                } else if (i == 0) {
                    res[i][j] = res[i][j] || res[i + 1][j - 1];


                } else {
                    res[i][j] = res[i][j] || (res[i - 1][j - 1] && res[i + 1][j - 1]);
                }
            }
        }

        boolean result = true;
        for (int i = 0; i < numCaves; i++) {
            if (!result) {
                break;
            } else {
                result = result && res[i][days - 1];
            }

        }
        return result;
    }
}
