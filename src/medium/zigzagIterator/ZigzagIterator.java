package medium.zigzagIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
    Queue<Iterator> queue = null;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if(v1 != null && v1.size() > 0) {
            queue.add(v1.iterator());
        }
        if(v2 != null && v2.size() > 0) {
            queue.add(v2.iterator());
        }
    }

    public int next() {
        Iterator current = queue.poll();
        int result = (Integer) current.next();
        if(current.hasNext()) {
            queue.add(current);
        }
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
