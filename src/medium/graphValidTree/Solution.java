package medium.graphValidTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n < 0) {
            return false;
        }
        if(edges == null || edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nodes.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++) {
            nodes.get(edges[i][0]).add(edges[i][1]);
            nodes.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        boolean[] path = new boolean[n];
        path[0] = true;

        if(!dfs(0, -1, nodes, visited, path)) {
            return false;
        }

        // check whether every node get visited
        for(int i = 1; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int pre, List<List<Integer>> nodes, boolean[] visited, boolean[] path) {
        for(int nb : nodes.get(node)) {
            // circle occurs, visit some nodes we visited before
            if(nb != pre && path[nb]) {
                return false;
            }
            if(!visited[nb]) {
                visited[nb] = true;
                path[nb] = true;
                dfs(nb, node, nodes, visited, path);
                path[nb] = false;
            }
        }
        return true;
    }
}
