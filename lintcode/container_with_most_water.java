public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     * O(n).
     */
    public int maxArea(int[] heights) {
        // write your code here
        int max = 0; 
        int len = heights.length; 
        int l = 0; 
        int r = len - 1; 
        
        while (l < r) {
            int h = Math.min(heights[l], heights[r]);
            int w = r - l; 
            max = Math.max(max, h * w);
            
            if (heights[l] < heights[r]) {
                l++; 
            } else {
                r--; 
            }
        }
        
        return max; 
    }
}
