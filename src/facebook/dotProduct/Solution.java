package facebook.dotProduct;

import java.util.*;
public class Solution {
    public int dotProduct(List<Node> l1, List<Node> l2) {
        if(l1 == null || l1.size() == 0 || l2 == null || l2.size() == 0) {
            return 0;
        }

        // check which one is shorter
        if(l1.size() > l2.size()) {
            List<Node> temp = l2;
            l2 = l1;
            l1 = temp;
        }

        int sum = 0;
        for(int i = 0; i < l1.size(); i++) {
            Node node1 = l1.get(i);
            // using binary search to find l2
            int start = 0;
            int end = l2.size() - 1;
            while(start <= end) {
                int mid = start + (end - start) / 2;
                Node midNode = l2.get(mid);
                if(midNode.index == node1.index) {
                    sum += node1.value * midNode.value;
                    break;
                }
                else if(midNode.index < node1.index) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Node node1 = new Node(0, 1);
        Node node2 = new Node(5, 2);
        Node node3 = new Node(10, 3);
        List<Node> l1 = new ArrayList<>();
        l1.add(node1);
        l1.add(node2);
        l1.add(node3);
        List<Node> l2 = new ArrayList<>();
        for(int i = 2; i <= 15; i++) {
            Node node = new Node(i, i);
            l2.add(node);
        }

        Solution sol = new Solution();
        System.out.println(sol.dotProduct(l2, l1));
    }

}

class Node {
    int index;
    int value;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
