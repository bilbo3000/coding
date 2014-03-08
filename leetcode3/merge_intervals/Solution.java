public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start; 
            }
            
        }); 
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i); 
            Interval prev = intervals.get(i - 1);
            
            if (prev.end >= curr.start) {
                prev.start = Math.min(prev.start, curr.start);
                prev.end = Math.max(prev.end, curr.end); 
                intervals.remove(i);
                i--; 
            }
        }   
        
        return intervals; 
    }
}
