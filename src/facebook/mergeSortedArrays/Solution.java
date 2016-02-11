package facebook.mergeSortedArrays;

import java.util.*;
public class Solution {
    public int[] merge(List<Integer[]> arrays) {
        if(arrays == null || arrays.size() == 0) {
            return new int[0];
        }

        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });

        int totalCount = 0;
        Node node;
        for(int i = 0; i < arrays.size(); i++) {
            Integer[] array = arrays.get(i);
            if(array != null && array.length != 0) {
                totalCount += array.length;
                node = new Node(array[0], 0, i);
                heap.add(node);
            }
        }

        int[] results = new int[totalCount];
        int index = 0;
        while(!heap.isEmpty()) {
            node = heap.poll();
            results[index++] = node.val;
            if(node.index < arrays.get(node.arrayIndex).length - 1) {
                node.index = node.index + 1;
                node.val = arrays.get(node.arrayIndex)[node.index];
                heap.add(node);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Integer[] a1 = {1,3,5,7,9};
        Integer[] a2 = {2,4,6,8,10};
        Integer[] a3 = {3,6,9,12,15};
        List<Integer[]> arrays = new ArrayList<>();
        arrays.add(a1);
        arrays.add(a2);
        arrays.add(a3);
        Solution sol = new Solution();
        int[] results = sol.merge(arrays);
        for(int result : results) {
            System.out.print(result + " ");
        }
    }

}

class Node {
    int val;
    int index;
    int arrayIndex;

    Node(int val, int index, int arrayIndex) {
        this.val = val;
        this.index = index;
        this.arrayIndex = arrayIndex;
    }
}
