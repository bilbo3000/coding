/**
 * Given a list of numbers, find the max contained water if using two 
 * numbers as container edges. 
 * The ideas was to use two pointers, and advance the shorter edge each 
 * time. Because if shorten the bottom edge, the only way to increase 
 * the max area is to increase the shorter vertical edge. Thus we need 
 * to advance the shorter edge each time. 
 */ 
public class Solution {
    public int maxArea(int[] height) {
        int result = 0; 
        int len = height.length;
        
        if (len == 0) {
            return result; 
        }
        
        int i = 0; 
        int j = len - 1; 
        
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            result = Math.max(result, area); 
            
            if (height[i] < height[j]) {
                int a = i; 
                
                while (height[a] <= height[i] && a < j) {
                    a++; 
                }
                
                i = a; 
            }
            else {
                int b = j; 
                
                while (height[b] <= height[j] && b > i) {
                    b--; 
                }
                
                j = b; 
            }
        }
        
        return result; 
    }
}
