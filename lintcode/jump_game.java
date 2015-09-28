public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     * 
     * Greedy approach. 
     * The idea was to maintain the max index it can reach so far. Initialized 
     * with the first element in the array. For each element, if its index is
     * more than curr max index, then it is impossible to reach current position. 
     * Otherwise, update max index if necessary and move on. 
     * O(n). 
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int len = A.length; 
        int maxIndex = A[0] - 1; 
        
        for (int i = 1; i < len; i++) {
            if (i > maxIndex) {
                return false; 
            } else {
                maxIndex = Math.max(maxIndex, i + A[i]);
            }
        }
        
        if (maxIndex >= len - 1) {
            return true; 
        }
        
        return false; 
    }
}

