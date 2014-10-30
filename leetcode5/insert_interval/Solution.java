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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0; 
        
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            Interval curr = intervals.get(i); 
            if (curr.end >= newInterval.start) {
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end); 
                intervals.remove(i); 
                i--; 
            }
            
            i++; 
        }
        
        if (i == intervals.size()) {
            intervals.add(newInterval); 
        } else {
            intervals.add(i, newInterval); 
        }
        
        return intervals; 
    }
}
