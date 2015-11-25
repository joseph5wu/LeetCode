package hard.mergeIntervals;

import commons.models.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> results = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) {
            return results;
        }

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            }
        });

        Interval prev = intervals.get(0);
        Interval node = null;
        for(int i = 1; i < intervals.size(); i++) {
            node = intervals.get(i);
            if(prev.end >= node.start) {
                Interval merged = new Interval(prev.start, Math.max(prev.end, node.end));
                prev = merged;
            }
            else {
                results.add(prev);
                prev = node;
            }
        }
        results.add(prev);

        return results;
    }
}
