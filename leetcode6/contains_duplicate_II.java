/**
 * Check whether there are duplicates at two distinct indexes where the 
 * difference between two indexes are at most k. 
 * Brute force solution is O(nK). For each element, look at at most k 
 * elements after it to see if there is any duplicates. This approach 
 * timeouts. 
 * A better approach is to take advantage of the fact that if we could not 
 * find duplicates in a window of k + 1 elements, it means all the elements in 
 * this window are distinct. Then shift the window right one position, and 
 * just need to compare the new element with previous elements in the window. 
 * This approach avoids many unnecessary comparisions. 
 */ 
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0; 
        int j = i + 1; 
        int len = nums.length; 
        
        // Find the first window
        while (j <= i + k && j < len) {
            if (nums[i] == nums[j]) {
                return true; 
            }
            
            j++; 
        }
        
        if (j == len) {
            return false; 
        }
        
        i = i + 1; 
        
        while (i < len - k) {
            int x = nums[i + k]; 
            
            for (int h = i; h < i + k; h++) {
                if (nums[h] == x) {
                    return true;
                }
            }
            
            i++; 
        }
        
        return false; 
    }
}
