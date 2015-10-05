public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     * 
     * Solve it using a stack. Elements in the stack means the amount of water 
     * at those index is uncertain. Also maintain a left edge. For each element, 
     * if less than edge, push to stack. Otherwise, pop elements from stack and
     * count water. Now, the amount of water between edge and current index is 
     * done. Then update current index to be the new edge. 
     * After going through all elements in the list, there could be some elements
     * left in the stack. Use the same approach but maintaining a right edge to 
     * process the remaining elements in the stack. 
     * 
     * O(n)
     */
    public int trapRainWater(int[] heights) {
        int len = heights.length; 
        int left = 0; 
        int count = 0; 
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 1; i < len; i++) {
            if (heights[i] < heights[left]) {
                stack.push(i);
            } else {
                int h = Math.min(heights[i], heights[left]);
                
                while (!stack.isEmpty()) {
                    int index = stack.pop(); 
                    count += h - heights[index]; 
                }
                
                left = i; 
            }
        }
        
        if (stack.isEmpty()) {
            return count; 
        }
        
        int right = stack.pop(); 
        
        while (stack.size() != 0) {
            int index = stack.pop(); 
            
            if (heights[index] < heights[right]) {
                count += heights[right] - heights[index]; 
            } else {
                right = index; 
            }
        }
        
        return count; 
    }
}
