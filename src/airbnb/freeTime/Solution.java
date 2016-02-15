package airbnb.freeTime;

import java.util.*;
public class Solution {
    public static List<Interval> freeTime(List<List<Interval>> intervals) {
        List<Interval> results = new ArrayList<>();
        if(intervals == null || intervals.isEmpty()) {
            return results;
        }

        List<Time> times = new ArrayList<>();
        for(List<Interval> list : intervals) {
            for(Interval inter : list) {
                Time start = new Time(inter.start, 0);
                Time end = new Time(inter.end, 1);
                times.add(start);
                times.add(end);
            }
        }

        // sort the timing
        Collections.sort(times, new Comparator<Time>() {
            public int compare(Time t1, Time t2) {
                if(t1.time != t2.time) {
                    return t1.time - t2.time;
                }
                return t1.flag - t2.flag;
            }
        });

        int count = 0;
        int startTime = 0;
        int max = 0;
        for(Time time : times) {
            if(time.flag == 0) {
                count++;
                if(count == 1 && startTime != 0) {
                    results.add(new Interval(startTime, time.time));
                }
                max = Math.max(max, count);
            }
            else {
                count--;
                if(count == 0) {
                    startTime = time.time;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println("Busies time # of employers = " + max);
        return results;
    }

    public static List<Interval> freeTime2(List<List<Interval>> intervals) {
        List<Interval> allInters = new ArrayList<>();
        for(List<Interval> list : intervals) {
            for(Interval inter : list) {
                allInters.add(inter);
            }
        }

        Collections.sort(allInters, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if(i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                return i1.end - i2.end;
            }
        });

        List<Interval> results = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(allInters.get(0).end);
        int count = 1;
        for(int i = 1; i < allInters.size(); i++) {
            Interval inter = allInters.get(i);
            int peekEndTime = heap.peek();
            if(peekEndTime < inter.start) {
                if(heap.size() == 1) {
                    results.add(new Interval(peekEndTime, inter.start));
                }
                heap.poll();
            }
            else {
                count++;
            }
            heap.add(inter.end);
        }
        System.out.println("Busies time # of employers = " + count);
        return results;
    }

    public static void main(String[] args) {
        List<Interval> e1 = new ArrayList<>();
        Interval i1 = new Interval(5, 8);
        Interval i2 = new Interval(15, 18);
        e1.add(i1);
        e1.add(i2);
        List<Interval> e2 = new ArrayList<>();
        Interval i3 = new Interval(7, 9);
        Interval i4 = new Interval(2, 6);
        Interval i5 = new Interval(10, 14);
        e2.add(i3);
        e2.add(i4);
        e2.add(i5);
        List<Interval> e3 = new ArrayList<>();
        Interval i6 = new Interval(11, 13);
        Interval i7 = new Interval(20, 25);
        Interval i8 = new Interval(27, 29);
        e3.add(i6);
        e3.add(i7);
        e3.add(i8);
        List<List<Interval>> intervals = new ArrayList<>();
        intervals.add(e1);
        intervals.add(e2);
        intervals.add(e3);

        List<Interval> results = freeTime(intervals);
        System.out.println(results);

        results = freeTime2(intervals);
        System.out.println(results);
    }
}

class Time{
    int time;
    int flag;

    public Time(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
}

class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.start);
        sb.append("-");
        sb.append(this.end);
        sb.append("]");
        return sb.toString();
    }
}
