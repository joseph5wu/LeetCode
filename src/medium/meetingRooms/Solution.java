package medium.meetingRooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    Comparator<Interval> comparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        }
    };

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        // sort the interval
        Arrays.sort(intervals, comparator);

        int meetings = intervals.length;
        int rooms = 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals[0].end);
        for(int i = 1; i < meetings; i++) {
            if(intervals[i].start < heap.peek()) {
                rooms++;
            }
            else {
                heap.poll();
            }
            heap.add(intervals[i].end);
        }
        return rooms;
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null) {
            throw new IllegalArgumentException("invalid input");
        }

        Arrays.sort(intervals, comparator);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
