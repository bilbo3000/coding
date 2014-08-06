public class Solution {
    public int maxArea(int[] height) {
        int len = height.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int left = 0; 
        int right = len - 1; 
        int max = (right - left) * Math.min(height[left], height[right]);
        
        while (left < right) {
            if (height[left] < height[right]) {
                left++; 
            } else {
                right--; 
            }
            
            max = Math.max(max, (right - left) * Math.min(height[left], height[right])); 
        }
        
        return max; 
    }
}
