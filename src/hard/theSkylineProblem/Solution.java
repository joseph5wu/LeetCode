package hard.theSkylineProblem;

import java.util.*;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> results = new ArrayList<>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return results;
        }

        List<Edge> edges = new ArrayList<>();
        for(int[] building : buildings) {
            Edge start = new Edge(building[0], building[2], true);
            edges.add(start);
            Edge end = new Edge(building[1], building[2], false);
            edges.add(end);
        }

        // sort the edges
        Collections.sort(edges, new Comparator<Edge>() {
           public int compare(Edge e1, Edge e2) {
               if(e1.x != e2.x) {
                   return Integer.compare(e1.x, e2.x);
               }
               if(e1.isStart && e2.isStart) {
                   return Integer.compare(e2.height, e1.height);
               }
               if(!e1.isStart && !e2.isStart) {
                   return Integer.compare(e1.height, e2.height);
               }
               return e1.isStart ?  -1 : 1;
           }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>(10, Collections.reverseOrder());
        for(Edge edge : edges) {
            if(edge.isStart) {
                if(heap.isEmpty() || edge.height > heap.peek()) {
                    results.add(new int[]{edge.x, edge.height});
                }
                heap.add(edge.height);
            }
            else {
                heap.remove(edge.height);
                if(heap.isEmpty()) {
                    results.add(new int[]{edge.x, 0});
                }
                else if(edge.height > heap.peek()) {
                    results.add(new int[]{edge.x, heap.peek()});
                }
            }
        }

        return results;
    }
}

class Edge{
    int x;
    int height;
    boolean isStart;

    public Edge(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }
}
