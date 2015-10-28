/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     * 
     * O(n). 
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0; 
        
        while (i < intervals.size()) {
            Interval curr = intervals.get(i);
            
            if (!(curr.end < newInterval.start || newInterval.end < curr.start)) {
                // There's overlap 
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
                intervals.remove(i);
                i--; 
            } else if (curr.start > newInterval.end) {
                // No overlap
                break; 
            }
            
            i++; 
        }
        
        if (i == intervals.size()) {
            intervals.add(newInterval);
        } else {
            if (newInterval.start > intervals.get(i).start) {
                if (i == intervals.size() - 1) {
                    intervals.add(newInterval);
                } else {
                    intervals.add(i + 1, newInterval);
                }
            } else {
                intervals.add(i, newInterval);
            }
        }
        
        return intervals;
    }
}
