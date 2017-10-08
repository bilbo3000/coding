/*
Find the largest area of a container formed by two vertical lines and x axis. 

The idea is to start from two ends and moving towards each other, and keep 
track of the current max area. 
During each move, the x axis will be shorter, the only way to possiblely 
increase the area is to advance the shorter edge. 

Time: O(n)
Space: O(1)
*/
class Solution {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0; 
        }
        
        int max = 0; 
        int i = 0;
        int j = height.length - 1; 
        
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, area);
            
            if (height[i] < height[j]) {
                i++;
            } else {
                j--; 
            }
        }
        
        return max; 
    }
}
