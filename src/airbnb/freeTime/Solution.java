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
        // sort interval
        Collections.sort(allInters, new Comparator<Interval> () {
            public int compare(Interval i1, Interval i2) {
                if(i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                return i1.end - i2.end;
            }
        });


        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(allInters.get(0).end);
        int rooms = 1;
        Interval busy = new Interval(allInters.get(0).start, allInters.get(0).end);
        for(int i = 1; i < intervals.size(); i++) {
            Interval interval = allInters.get(i);
            int end = heap.peek();
            if(end <= interval.start) {
                heap.poll();
            }
            else {
                rooms++;
                busy.start = interval.start;
                busy.end = end;
            }
            heap.add(interval.end);
        }

        System.out.println("busy rooms: " + rooms + ", time=" + busy);


        List<Interval> free = new ArrayList<>();
        Interval base = allInters.get(0);
        for(int i = 1; i < allInters.size(); i++) {
            Interval interval = allInters.get(i);
            if(base.end < interval.start) {
                free.add(new Interval(base.end, interval.start));
                base = interval;
            }
            else {
                base.end = Math.max(base.end, interval.end);
            }
        }

        return free;
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
