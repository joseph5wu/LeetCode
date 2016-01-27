package amazon;

import commons.models.Point;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KNearestPoints {
    public Point[] kNearest(Point[] points, Point target, int k) {
        if(points == null || points.length < k || k < 1) {
            throw new IllegalArgumentException("Invalid input");
        }
        if(points.length == k) {
            return points;
        }

        Point[] results = new Point[k];
        // using PriorityQueue to sort the point
        // since we need to find nearest so we using descending order
        PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return ((p2.x - target.x) * (p2.x - target.x) + (p2.y - target.y) * (p2.y - target.y))
                       - ((p1.x - target.x) * (p1.x - target.x) + (p1.y - target.y) * (p1.y - target.y));
            }
        });

        for(Point p : points) {
            queue.offer(p);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int index = k - 1;
        while(!queue.isEmpty()) {
            results[index--] = queue.poll();
        }
        return results;
    }

    public static void main(String[] args) {
        Point[] points = new Point[5];
        points[4] = new Point(0, 1);
        points[3] = new Point(1, 0);
        points[2] = new Point(1, 1);
        points[1] = new Point(0, 2);
        points[0] = new Point(2, 0);
        KNearestPoints sol = new KNearestPoints();
        Point[] result = sol.kNearest(points, new Point(0, 0), 3);
        for(Point p : result) {
            System.out.println(p.toString());
        }
    }
}
