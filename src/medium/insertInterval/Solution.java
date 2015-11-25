package medium.insertInterval;

import commons.models.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<>();
        if(intervals == null || intervals.isEmpty()) {
            results.add(newInterval);
            return results;
        }
        if(newInterval == null) {
            return intervals;
        }

        for(Interval interval : intervals){
            if(interval.end < newInterval.start) {
                results.add(interval);
            }
            else if(interval.start > newInterval.end) {
                results.add(newInterval);
                newInterval = interval;
            }
            else{
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        results.add(newInterval);
        return results;
    }
}
