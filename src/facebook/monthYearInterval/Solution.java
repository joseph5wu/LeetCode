package facebook.monthYearInterval;
import java.util.*;

public class Solution {
    // using the Jan 2010 as the base
    private final Map<String, Integer> monthMap = new HashMap<>();

    private final int yearBase = 2011;

    public Solution() {
        monthMap.put("Jan", 0);
        monthMap.put("Feb", 1);
        monthMap.put("Mar", 2);
        monthMap.put("Apr", 3);
        monthMap.put("May", 4);
        monthMap.put("Jun", 5);
        monthMap.put("Jul", 6);
        monthMap.put("Aug", 7);
        monthMap.put("Sep", 8);
        monthMap.put("Oct", 9);
        monthMap.put("Nov", 10);
        monthMap.put("Dec", 11);
    }


    private List<Interval> format(String[] intervals) {
        List<Interval> results = new ArrayList<>();
        for(String interval : intervals) {
            results.add(format(interval));
        }
        return results;
    }

    private Interval format(String interval) {
        String[] info = interval.split("-");
        String startStr = info[0].trim();
        String endStr = info[1].trim();

        String[] startInfo = startStr.split(" ");
        String month = startInfo[0].trim();
        String year = startInfo[1].trim();
        int start = (Integer.parseInt(year) - yearBase) * 12 + monthMap.get(month);

        String[] endInfo = endStr.split(" ");
        month = endInfo[0].trim();
        year = endInfo[1].trim();
        int end = (Integer.parseInt(year) - yearBase) * 12 + monthMap.get(month);

        return new Interval(start, end);
    }

    public int getTotalTime(String[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        List<Interval> temp = format(intervals);


        Collections.sort(temp, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end;
            }
        });


        Interval prev = temp.get(0);
        Interval interval = null;
        int total = 0;
        for(int i = 1; i < temp.size(); i++) {
            interval = temp.get(i);
            if(prev.end < interval.start) {
                total += (prev.end - prev.start);
                prev = interval;
            }
            else if(prev.start > interval.end) {
                total += (interval.end - interval.start);
            }
            else {
                prev.start = Math.min(prev.start, interval.start);
                prev.end = Math.max(prev.end, interval.end);
            }
        }

        total += prev.end - prev.start;
        return total;
    }

    public static void main(String[] args) {
        String[] intervals = new String[]{"Apr 2010 - Dec 2010", "May 2010 - Nov 2010", "Jan 2011 - Mar 2011"};
        Solution sol = new Solution();
        System.out.println(sol.getTotalTime(intervals));
    }

}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

