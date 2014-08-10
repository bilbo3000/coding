/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override 
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start; 
            }
        }); 
        
        for (int i = 0; i < intervals.size(); i++) {
            if (i < intervals.size() - 1) {
                Interval curr = intervals.get(i);
                Interval next = intervals.get(i + 1); 
                
                if (curr.end >= next.start) {  // Overlap 
                    curr.start = Math.min(curr.start, next.start); 
                    curr.end = Math.max(curr.end, next.end); 
                    intervals.remove(i + 1); 
                    i--; 
                }
            }
        }
        
        return intervals; 
    }
}
