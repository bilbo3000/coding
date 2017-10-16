/*
Find the amount of water trapped. 

Step 1: Find the highest point. 
Step 2: Find amount of trapping water to its left; 
Step 3: Find amount of trapping water to its right; 

Time: O(n)
Space: O(1)
*/
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0; 
        }
        
        // Find the highest point
        int max = height[0]; 
        int maxIndex = 0; 
        
        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i]; 
                maxIndex = i; 
            }
        }
        
        int result = 0; 
        
        // Find amount of trapping water to its left
        int leftMax = height[0]; 
        int i = 1;
        
        while (i < maxIndex) {
            if (height[i] >= leftMax) {
                leftMax = height[i]; 
            } else {
                result += leftMax - height[i]; 
            }
            i++; 
        }
        
        // Find amount of trapping water to its right
        int rightMax = height[height.length - 1]; 
        i = height.length - 2;
        
        while (i > maxIndex) {
            if (height[i] >= rightMax) {
                rightMax = height[i]; 
            } else {
                result += rightMax - height[i]; 
            }
            i--; 
        }
        
        return result; 
    }
}
