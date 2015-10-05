public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     * 
     * Two dimentional backpack problem (both size and weight). Similar 
     * to backpack I, but instead of boolean matrix, use int matrix to keep track 
     * of max value. T[i][j]: the max value in first i elements that add up to 
     * capacity j. 
     * 
     * O(mn)
     */
    public int backPackII(int m, int[] A, int V[]) {
        int len = A.length; 
        
        // T[i][j]: in first i elements, the max value that adds up to capacity j.
        int[][] T = new int[len + 1][m + 1]; 
        T[0][0] = 0; 
        
        // Capacity is zero
        for (int i = 1; i <= len; i++) {
            T[i][0] = 0; 
        }
        
        // Zero element candidate
        for (int j = 1; j <= m; j++) {
            T[0][j] = 0; 
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                // Not include ith element 
                T[i][j] = T[i - 1][j]; 
                
                // Include ith element
                if (j >= A[i - 1]) {
                    T[i][j] = Math.max(T[i][j], V[i - 1] + T[i - 1][j - A[i - 1]]);
                }
            }
        }
        
        int max = 0; 
        
        for (int j = m; j >= 0; j--) {
            max = Math.max(max, T[len][j]);
        }
        
        return max; 
    }
}
