public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     * 
     * O(n) time. 
     */
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>(); 
        int max = 0; 
        
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    int h = height[stack.pop()];
                    int l = -1; 
                    
                    if (!stack.isEmpty()) {
                        l = stack.peek(); 
                    }
                    
                    max = Math.max(max, h * (i - l - 1));
                }
                
                stack.push(i);
            }
        }
        
        while (!stack.isEmpty()) {
            int h = height[stack.pop()]; 
            int l = -1; 
            
            if (!stack.isEmpty()) {
                l = stack.peek(); 
            }
            
            max = Math.max(max, h * (height.length - l - 1));
        }
        
        return max; 
    }
}

