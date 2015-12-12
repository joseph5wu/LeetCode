package medium.minimumHeightTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> results = new ArrayList<>();
        if(n == 1) {
            results.add(0);
            return results;
        }

        // get the adj map to store the bind relationship
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // get the leaves list based on owning only one adj node
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // repeating removing leaves node
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves) {
                // get the only one adj node
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
