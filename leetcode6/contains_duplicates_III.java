/**
 * Determine if an array contains two elements num[i], num[j] such that i,j diff at most k
 * and value diff at most t. 
 * The core idea was to use TreeSet, because it supports get subset of elements fall into a 
 * given range. 
 */ 
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
		return false;
		
        SortedSet<Long> set = new TreeSet<>(); 
        int len = nums.length; 
        
        for (int i = 0; i < len; i++) {
            long lower = (long) nums[i] - t;
            long upper = (long) nums[i] + t + 1; 
            
            SortedSet<Long> subset = set.subSet(lower, upper);
            
            if (subset.size() != 0) {
                return true; 
            }
            
            set.add((long)nums[i]);
            
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        
        return false; 
    }
}
