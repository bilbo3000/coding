/**
 * Trapping rain water. 
 * Solve it using a stack. The idea was to count how much water can be trapped on 
 * top of each position. Maintain the height of left edge. If current element is 
 * less than the edge, push onto the stack, meaning that the water above it is 
 * still uncertain. However, if current element is greater or equal to left edge, 
 * meaning that the water above all the elements in between now are fixed. Now 
 * we can pop them from the stack and count the water. Then, update left edge to 
 * current element. Once on more elements left in the array, there could still be 
 * some elements left in the stack, where the bottom element must be left edge. We 
 * can maintain a right edge and starting poping elements from the stack. If that 
 * element is less than the right edge, add count. Otherwise, update right edge 
 * accordingly, until there are no more elemenets left in the stack. 
 */ 
public class Solution {
    public int trap(int[] A) {
        int len = A.length; 
        int result = 0; 
        
        if (len == 0) {
           return result;  
        }
        
        Stack<Integer> stack = new Stack<>(); 
        stack.push(A[0]); 
        int leftMax = A[0]; 
        
        for (int i = 1; i < len; i++) {
            if (A[i] < leftMax) {
                stack.push(A[i]);
                continue; 
            }
            
            while (stack.size() != 0 && stack.peek() <= A[i]) {
                int val = stack.pop(); 
                
                if (leftMax > val) {
                    result += leftMax - val; 
                }
            }
            
            stack.push(A[i]); 
            leftMax = A[i]; 
        }
        
        if (stack.size() != 0) {
            int rightMax = stack.pop(); 
            
            while (stack.size() != 0) {
                int val = stack.pop(); 
                
                if (val >= rightMax) {
                    rightMax = val; 
                    continue; 
                }
                
                result += rightMax - val; 
            }
        }
        
        return result; 
    }
}
