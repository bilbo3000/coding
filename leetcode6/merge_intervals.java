/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * 
 * Merge intervals. 
 * The idea was to first sort the intervals based on start and end. Then keep merging 
 * all the intervals that overlap with the current interval. 
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override 
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) {
                    return a.start - b.start; 
                } else {
                    return a.end - b.end; 
                }
            }
        });
        
        int i = 0; 
        
        while (i < intervals.size()) {
            if (i < intervals.size() - 1) {
                Interval curr = intervals.get(i);
                Interval next = intervals.get(i + 1);
                
                if (!(curr.end < next.start || curr.start > next.end)) {
                    curr.start = Math.min(curr.start, next.start);
                    curr.end = Math.max(curr.end, next.end);
                    intervals.remove(i + 1);
                    i--;
                }
            }
            i++; 
        }
        
        return intervals; 
    }
}
