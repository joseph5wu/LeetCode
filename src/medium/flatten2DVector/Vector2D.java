package medium.flatten2DVector;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Vector2D {

    Queue<Iterator<Integer>> queue = null;
    Iterator<Integer> current = null;

    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        for(int i = 0; i < vec2d.size(); i++) {
            queue.add(vec2d.get(i).iterator());
        }

        current = queue.poll();
    }

    public int next() {
        if(!current.hasNext()) {
            return Integer.MIN_VALUE;
        }
        else {
            return current.next();
        }
    }

    public boolean hasNext() {
        if(current == null) {
            return false;
        }

        while(!current.hasNext()) {
            if(!queue.isEmpty()) {
                current = queue.poll();
            }
            else {
                return false;
            }
        }

        return true;
    }
}
