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
    class Cmp implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start; 
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Cmp()); 
        
        int i = 0; 
        
        while (i < intervals.size() - 1) {
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i + 1); 
            
            if (curr.end >= next.start) {
                curr.end = Math.max(curr.end, next.end);
                intervals.remove(i + 1); 
                i--; 
            }
            
            i++; 
        }
        
        return intervals; 
    }
}
