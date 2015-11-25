package medium.peekingIterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it = null;
    private Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        if(iterator.hasNext()) {
            peek = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = peek;
        peek = it.hasNext() ? it.next() : null;
        return next;
    }

    @Override
    public boolean hasNext() {
        return peek != null;
    }
}
