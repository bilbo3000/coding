import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] h) {
        int len = h.length; 
        int[] height = new int[len + 2];
        
        for (int i = 0; i < len; i++) {
            height[i + 1] = h[i]; 
        }
        
        Stack<Integer> stack = new Stack<Integer>(); 
        int max = 0; 
        
        // Scan from left to right 
        for (int i = 0; i < len + 2; i++) {
            if (stack.size() == 0 || height[i] > height[stack.peek()]) {
                stack.push(i); 
            }
            else {
                while (stack.size() > 0 && height[stack.peek()] > height[i]) {
                    int temp = stack.pop(); 
                    int rightArea = (i - temp) * height[temp]; 
                    int leftArea = 0; 
                    
                    if (stack.size() != 0) {
                        leftArea = (temp - stack.peek() - 1) * height[temp]; 
                    }
                    
                    // System.out.println("left: " + leftArea); 
                    // System.out.println("right: " + rightArea); 
                    
                    max = Math.max(max, leftArea + rightArea); 
                }
                
                stack.push(i); 
            }
        }
        
        return max; 
    }
}
