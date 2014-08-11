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
        int index = -1; 
        
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start > newInterval.end) {
                index = i; 
                break; 
            } 
                
            if (!(newInterval.start > curr.end || newInterval.end < curr.start)) {
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end); 
                index = i; 
                intervals.remove(i);
                i--; 
            }
        }
        
        if (index != -1) {
            intervals.add(index, newInterval); 
        } else {
            intervals.add(newInterval); 
        }
        
        return intervals; 
    }
}
