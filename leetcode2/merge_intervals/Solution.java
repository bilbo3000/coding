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
    class Cmp implements Comparator<Interval>{
        @Override
        public int compare(Interval a, Interval b) {
           return a.start - b.start;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Cmp());

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i + 1);

            if (next.start <= curr.end){  // Overlaps
                next.start = Math.min(curr.start, next.start);
                next.end = Math.max(curr.end, next.end);
                intervals.remove(i);
                i--;
            }
        }

        return intervals;
    }
}
