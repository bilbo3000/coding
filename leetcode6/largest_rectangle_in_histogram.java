/**
 * Find the maximum rectangle area. 
 * Solve it using stack to store index. The idea was that smaller elements will "clear" 
 * all larger or equal elements in the stack. While clearing elements, computes the area
 * that is bounded by that element. Becase the element in front of it must be smaller and 
 * thus is the left bound. The current element is also smaller and thus must be right 
 * bound. Then we can calculate the area bounded by that element. Note that the remaining 
 * elements left in the stack will compute in the same way bounded by right index len - 1 
 * because after that element, there must no emaller elements after it. 
 */ 
public class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        Stack<Integer> stack = new Stack<>(); 
        int result = 0;
        stack.add(0);
        
        for (int i = 1; i < len; i++) {
            if (stack.size() == 0 || height[stack.peek()] < height[i]) {
                stack.push(i);
            } else {
                while (stack.size() > 0 && height[stack.peek()] >= height[i]) {
                    int index = stack.pop(); 
                    int lindex = -1; 
                    
                    if (stack.size() != 0) {
                        lindex = stack.peek(); 
                    }
                    
                    result = Math.max(result, height[index] * (i - 1 - lindex)); 
                }
                
                stack.push(i); 
            }
        }
        
        while (stack.size() != 0) {
            int index = stack.pop(); 
            int lindex = -1; 
            
            if (stack.size() != 0) {
                lindex = stack.peek(); 
            }
            
            result = Math.max(result, height[index] * (len - 1 - lindex));
        }
        
        return result; 
    }
}
