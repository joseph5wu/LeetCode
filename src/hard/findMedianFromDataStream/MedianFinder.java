package hard.findMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    // store the smaller half of all elements
    private PriorityQueue<Integer> min;
    // store the larger half
    private PriorityQueue<Integer> max;
    private int size = 0;

    public MedianFinder() {
        this.min = new PriorityQueue<>(Collections.reverseOrder());
        this.max = new PriorityQueue<>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        // if the number of elements is even, then add the new element to min and make sure that min heap can have only
        // one extra element than max
        if(size % 2 == 0) {
            min.add(num);
        }
        else {
            min.add(num);
            max.add(min.poll());
        }
        size++;

        if(size > 1 && min.peek() > max.peek()) {
            min.add(max.poll());
            max.add(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return size % 2 == 0 ? (min.peek() + max.peek()) / 2.0 : min.peek();
    }
}
