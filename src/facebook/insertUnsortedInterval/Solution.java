package facebook.insertUnsortedInterval;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public Pair insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<>();
        if(newInterval == null) {
            Pair pair = new Pair(calculateTotalTime(intervals), intervals);
            return pair;
        }
        if(intervals == null || intervals.size() == 0) {
            results.add(newInterval);
            Pair pair = new Pair(newInterval.end - newInterval.start, results);
            return pair;
        }

        // sort the original intervals
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if(i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                else {
                    return i1.end - i2.end;
                }
            }
        });

        int total = 0;
        for(Interval interval : intervals) {
            if(interval.end < newInterval.start) {
                total += (interval.end - interval.start);
                results.add(interval);
            }
            else if(interval.start > newInterval.end) {
                total += (newInterval.end - newInterval.start);
                results.add(newInterval);
                newInterval = interval;
            }
            else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        total += (newInterval.end - newInterval.start);
        results.add(newInterval);
        return new Pair(total, results);

    }

    private int calculateTotalTime(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) {
            return 0;
        }

        int total = 0;
        for(Interval interval : intervals) {
            total += (interval.end - interval.start);
        }

        return total;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Solution test = new Solution();
        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(6, 9);
        intervals.add(i1);
        intervals.add(i2);
        Interval newInterval = new Interval(2, 5);
        Pair result = test.insert(intervals, newInterval);
        System.out.println(result.total);
        System.out.println(result.intervals);
        // System.out.println("Hello World");
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class Pair {
    int total;
    List<Interval> intervals;

    public Pair(int total, List<Interval> intervals) {
        this.total = total;
        this.intervals = intervals;
    }
}

