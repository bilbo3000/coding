/**
 * Given an integer array. Determine the minimum number of jumps 
 * from the beginning to the end. 
 * 
 * This is O(n^2) DP solution. T[i] is the minimum number of jumps
 * to get to location i. For each T[i], it loops previous reachable 
 * positions and find the minimum. 
 * 
 * Time: O(n^2). Time out. 
 * Space: O(n)
 */ 
class Solution {
    public int jump(int[] nums) {
        int length = nums.length; 
        
        if (length == 0 || length == 1) {
        	return 0;
        }
        
        // T[i]: the min jumps to position i
        int[] T = new int[length]; 
        T[1] = 1; 
        
        for (int i = 2; i < length; i++) {
        	T[i] = Integer.MAX_VALUE; 
        	
        	for (int j = i - 1; j >= 0; j--) {
        		if ((j + nums[j]) >= i) {
        			// From j is reachable to i
        			T[i] = Math.min(T[i], T[j] + 1);
        		}
        	}
        }
        
        return T[length - 1];
    }
}
