/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * 
 * O(nlogn)
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start; 
            }
        });
        
        int i = 1; 
        
        while (i < intervals.size()) {
            Interval in1 = intervals.get(i - 1); 
            Interval in2 = intervals.get(i);
            
            if (!(in1.end < in2.start)) {
                // There is overlap
                int start = Math.min(in1.start, in2.start);
                int end = Math.max(in1.end, in2.end);
                in1.start = start; 
                in1.end = end; 
                intervals.remove(i);
                i--; 
            }
            
            i++; 
        }
        
        return intervals; 
    }

}
