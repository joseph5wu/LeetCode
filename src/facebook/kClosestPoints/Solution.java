package facebook.kClosestPoints;

import java.util.*;
public class Solution {
    public List<Point> kClosestPoints(Point[] points, Point target, int k) {
        List<Point> results = new ArrayList<>();
        if(k <= 0 || points == null || points.length == 0 || target == null) {
            return results;
        }

        // using a heap to quick sort the distance, while the farthest is on the top
        PriorityQueue<Point> heap = new PriorityQueue<>(new Comparator<Point> () {
            public int compare(Point p1, Point p2) {
                return ((p2.x - target.x) * (p2.x - target.x) + (p2.y - target.y) * (p2.y - target.y)) - ((p1.x - target.x) * (p1.x - target.x) + (p1.y - target.y) * (p1.y - target.y));
            }
        });

        // push the points array into the heap to get the closest points
        for(Point point : points) {
            heap.offer(point);
            while(heap.size() > k) {
                System.out.println((heap.peek()).toString());
                heap.poll();
            }
        }

        // loop the heap to get the results
        while(!heap.isEmpty()) {
            Point point = heap.poll();
            results.add(0, point);
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

        Solution sol = new Solution();
        List<Point> results = sol.kClosestPoints(points, new Point(2, 2), 3);
        for(Point point : results) {
            System.out.print(point.toString());
        }
    }

}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}

