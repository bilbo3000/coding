/**
 * Given a list of max jump ranges, find the minimum number of jumps from start to end. 
 * The naive approach was first initialize the steps array with 1 for all indexs that 
 * are reachable with one jump. Then for the remaining indexs, looking backwards and gets 
 * the min. However this approach times out, because this is a O(n^2) algorithm.
 * 
 * Below is a better approach. 
 * The idea was to update a segment at a time. First find all indexs can be reached with 
 * one step, then find all indexs can be reached with two steps, so one so forth. This 
 * algorithm is linear. 
 */ 
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T = new int[len]; 
        T[0] = 0; 
        int val = 0; // Number of steps for current segment.
        int i = 1; 
        int maxIndex = nums[0]; // End index for next segment. 
        
        while (i < len) {
        	int end = maxIndex; // End point for crrent segment. 
	        while (i < len && i <= end) {
	            T[i] = val + 1; 
	            maxIndex = Math.max(maxIndex, i + nums[i]);  // Keep update the end index for next segment. 
	            i++;
	        } 
	        
	        val = val + 1; 
        }
        
        return T[len - 1]; 
    }
}
