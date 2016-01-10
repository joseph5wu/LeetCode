package medium.numberOfConnectedComponents;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = n;

        if(n < 1 || edges.length == 0) {
            return n;
        }

        int[] root = new int[n];
        for(int i = 0; i < n; i++) {
            root[i] = i;
        }

        for(int i = 0; i < edges.length; i++) {
            int root1 = findRoot(root, edges[i][0]);
            int root2 = findRoot(root, edges[i][1]);
            if(root1 != root2) {
                root[root2] = root1;
                count--;
            }
        }

        return count;
    }

    private int findRoot(int[] root, int index) {
        while(root[index] != index) {
            index = root[index];
        }

        return index;
    }
}
