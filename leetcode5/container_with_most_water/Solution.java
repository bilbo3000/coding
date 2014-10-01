public class Solution {
    public int maxArea(int[] height) {
        int max = 0; 
        int len = height.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int l = 0; 
        int r = len - 1; 
        
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l)); 
            
            if (height[l] < height[r]) {
                l++; 
            } else {
                r--; 
            }
        }
        
        return max; 
    }
}
