public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     * 
     * One dimentional backpack problem. 
     * Solve it using dynamic programming. 
     * boolean T[i][j] meaning whether first i elements can add up to capacity j.
     * When calculating T[i][j], consider whether include the ith element or not.
     * In the end, checking T[A.length][from m to 0], the j index of the first 
     * true would be the max capacity. 
     * 
     * O(nm)
     */
    public int backPack(int m, int[] A) {
        int len = A.length; 
        
        // T[i][j]: whether first i elements can add up to capacity j
        boolean[][] T = new boolean[len + 1][m + 1]; 
        T[0][0] = true; 
        
        // When capacity is zero
        for (int i = 1; i <= len; i++) {
            T[i][0] = false; 
        }
        
        // When element candidates is zero
        for (int j = 1; j <= m; j++) {
            T[0][j] = false; 
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                // Not include the ith element
                T[i][j] = T[i - 1][j]; 
                
                // Include the ith element
                if (j == A[i - 1]) {
                    T[i][j] = true; 
                } else if (j > A[i - 1]) {
                    T[i][j] |= T[i - 1][j - A[i - 1]];
                }
            }
        }
        
        for (int j = m; j >= 0; j--) {
            if (T[len][j]) {
                return j; 
            }
        }
        
        return 0;
    }
}
