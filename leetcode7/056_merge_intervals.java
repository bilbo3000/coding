/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 
 Merge a list of intervals into a list of disjoint intervals. 
 
 First sort the origin list based on the starting endpoint. 
 Walk through the origin list, and try merge each current element 
 with the last element in the result list. 
 
 Time: O(nlogn), sorting; 
 Space: O(n), worse case all lists are disjoint. 
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        
        // Sort list of intervals by left endpoint
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        
        List<Interval> result = new ArrayList<>(); 
        result.add(intervals.get(0));
        
        for (Interval i : intervals) {
            Interval prev = result.get(result.size() - 1);
            
            if (i.start <= prev.end) {
                // New interval merge with previous interval
                prev.end = Math.max(prev.end, i.end);
            } else {
                result.add(i);
            }
        }
        
        return result; 
    }
}
