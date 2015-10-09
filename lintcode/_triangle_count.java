public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     * 
     * O(nlogn)
     */
    public int triangleCount(int S[]) {
        int count = 0; 
        int len = S.length; 
        Arrays.sort(S);
        
        for (int i = 0; i < len; i++) {
            int left = 0; 
            int right = i - 1; 
            
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    // 两小边大于长边
                	// For every edge in middle, it must also satisfy
                	// so bulk add
                    count = count + (right - left); 
                    
                    // Decrement longer edge
                    right--; 
                }  else {
                    // increment shorter edge
                    left++; 
                }
            }
        }
        
        return count; 
    }
}

