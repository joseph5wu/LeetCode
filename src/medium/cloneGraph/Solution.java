package medium.cloneGraph;

import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.poll();
            map.put(temp, new UndirectedGraphNode(temp.label));
            for(UndirectedGraphNode neighbor : temp.neighbors) {
                if(!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        for(UndirectedGraphNode temp : map.keySet()) {
            UndirectedGraphNode newNode = map.get(temp);
            for(UndirectedGraphNode neighbor : temp.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
