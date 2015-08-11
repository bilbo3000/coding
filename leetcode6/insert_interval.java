/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * 
 * Insert a interval into an array of intervals that are sorted based on start value 
 * and merge all overlaped intervals accordingly. 
 * The idea was to loop through the intervals till the end of the list or the first 
 * interval that is complete beind the newInterval. For each element, if it is overlap 
 * with newInterval, we need to update the newInterval and remove that element from the 
 * array. After finish walking through the array, we need to insert the new interval at 
 * index i, which could be the end of the array. 
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0; 
        
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            Interval interval = intervals.get(i); 
            
            if (!(interval.end < newInterval.start || interval.start > newInterval.end)) {
                // Overlap
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
                intervals.remove(i);
                i--;
            }
            i++; 
        }
        
        if (i < intervals.size()) {
            intervals.add(i, newInterval);
        } else {
            intervals.add(newInterval);
        }
        
        return intervals; 
    }
}
