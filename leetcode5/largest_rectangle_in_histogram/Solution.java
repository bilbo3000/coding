public class Solution {
    public int largestRectangleArea(int[] h) {
        int result = 0; 
        Stack<Integer> s = new Stack<Integer>(); 
        int len = h.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] height = new int[len + 1]; 
        
        for (int i = 0; i < len; i++) {
            height[i] = h[i]; 
        }
        
        height[len] = 0; 
        
        s.push(0);
        result = height[0]; 
        int i = 1; 
        
        while (i <= len) {
            if (s.size() == 0) {
                s.push(i); 
            } else {
                if (height[s.peek()] <= height[i]) {
                    s.push(i); 
                } else {
                    while (s.size() > 0 && height[s.peek()] > height[i]) {
                        int index = s.pop(); 
                        int right = height[index] * (i - index); 
                        int left = 0; 
                        
                        if (s.size() == 0) {
                            left = height[index] * index; 
                        } else {
                            left = height[index] * (index - s.peek() - 1); 
                        }
                        
                        result = Math.max(result, left + right); 
                    }
                    
                    s.push(i); 
                }
            }
            
            i++; 
        }
        
        return result; 
    }
}
