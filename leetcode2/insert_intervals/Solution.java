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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0; 
        
        while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
            Interval curr = intervals.get(i); 
            
            if (curr.end >= newInterval.start) {  // Overlaps 
                newInterval.start = Math.min(curr.start, newInterval.start); 
                newInterval.end = Math.max(curr.end, newInterval.end); 
                intervals.remove(i); 
                i--; 
            }
            
            i++; 
        }
        
        intervals.add(i, newInterval); 
        
        return intervals; 
    }
}
