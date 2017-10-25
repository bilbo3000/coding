/*
Find largest rectangle in histogram. 

Solve is using a stack store index.(List of candiates heights)
Each incoming element will "clear" all its predecessors that are "greater" than it. 
The rectangle with those heights cannot extend to right any further, 
thus poped from the stack and calculated. 

Popped elements gives the height; 
Current element and current stack peek together gives the width; 
--> rectangle area can be calculated. 

Time: O(n), each element is popped from stack at most once;
Space: O(n), worse case all elements are in stack; 
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0; 
        }
        
        int len = heights.length; 
        
        // A stack stores index 
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
            int n = heights[i]; 
            
            if (stack.isEmpty()) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > n) {
                    // Top of stack cannot extends further to right
                    // Try calculated its area
                    int h = heights[stack.pop()]; 
                    
                    if (stack.isEmpty()) {
                        result = Math.max(result, h * i);
                    } else {
                        result = Math.max(result, h * (i - 1 - stack.peek()));
                    }
                }
                
                stack.add(i);
            }
        }
        
        // There still could be elements left in the stack
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            
            if (stack.isEmpty()) {
                result = Math.max(result, h * len);
            } else {
                result = Math.max(result, h * (len - 1 - stack.peek()));
            }
        }
        
        return result; 
    }
}
