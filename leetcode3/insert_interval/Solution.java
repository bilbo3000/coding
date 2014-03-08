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
        
        while (i < intervals.size()) {
            Interval item = intervals.get(i); 
            
            if (item.end >= newInterval.start) {
                if (item.end > newInterval.start && newInterval.end < item.start) {
                    break; 
                }
                else {  // Overlap 
                    newInterval.start = Math.min(newInterval.start, item.start); 
                    newInterval.end = Math.max(newInterval.end, item.end); 
                    intervals.remove(i);
                    i--; 
                }
            }
            
            i++; 
        }
        
        intervals.add(i, newInterval); 
        
        return intervals; 
    }
}
