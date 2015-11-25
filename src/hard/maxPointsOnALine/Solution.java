package hard.maxPointsOnALine;

import commons.models.Point;

public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        if(points.length <= 2) {
            return points.length;
        }

        int maxNum = 0;
        int pointsNum = points.length;
        int count = 0;
        int duplicates = 0;
        for(int i = 0; i < pointsNum; i++) {
            Point p = points[i];
            count = 0;
            duplicates = 0;

            for(int j = i + 1; j < pointsNum; j++) {
                Point q = points[j];
                if(p.x == q.x && p.y == q.y) {
                    duplicates++;
                    maxNum = Math.max(maxNum, duplicates + 1);
                    continue;
                }

                count = 1;
                for(int k = j + 1; k < pointsNum; k++) {
                    Point r = points[k];
                    count += isCoLinear(p, q, r) ? 1 : 0;
                }
                maxNum = Math.max(maxNum, count + duplicates + 1);
            }
        }

        return maxNum;
    }

    private boolean isCoLinear(Point p, Point q, Point r) {
        return (p.x - q.x) * (r.y - q.y) - (p.y - q.y) * (r.x - q.x) == 0;
    }
}
