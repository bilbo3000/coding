/**
 * Given an integer array. Find minimum jumps from beginning to end. 
 * (Guaranteed can jump). 
 * 
 * This is a DP + BFS solution. T[i] is the min steps jump to position i. 
 * Use BFS to populate T layer by layer: for each element i, populate all the 
 * rechable but hasn't filled positions with T[i] + 1. 
 * 
 * BFS is suiteable because it is good at finding shortest path. 
 * Also it can shortcut if for a given element, it only needs to 
 * populate reachable and unpopulated children. 
 * 
 * Time: O(n), because each cell is only populated once. 
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
        int index = 1; // The first position need to fill
        
        for (int i = 0; i < length; i++) {
        	int temp = nums[i]; 
        	
        	if (temp + i >= index) {
        		int j = index; 
        		while (j <= temp + i && j < length) {
        			T[j] = T[i] + 1; 
        			j++; 
        			index++; 
        			
        			if (index == length) {
        				return T[length - 1]; 
        			}
        		}
        	}
        }
        
        return T[length - 1];
    }
}
