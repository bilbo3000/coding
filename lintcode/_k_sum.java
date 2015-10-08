public class Solution {
    
    private int count = 0; 
    
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     * 
     * Dynamic programming approach. 
     */
    public int kSum(int A[], int k, int target) {
        int n = A.length; 
        
        // T[i][j][k]: the number of solution from first 
        // ith numbers pick j numbers such that their sum
        // is k
        int[][][] T = new int[n + 1][k + 1][target + 1]; 

        for (int i = 0; i <= n; i++) {
            // There is one way to pick 0 element 
            // that sum is zero. 
            T[i][0][0] = 1; 
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    if (t >= A[i - 1]) {
                        // Include current element
                        T[i][j][t] = T[i - 1][j - 1][t - A[i - 1]];
                    }
                    
                    // add the case do not include current  
                    T[i][j][t] += T[i - 1][j][t]; 
                }
            }
        }
        
        return T[n][k][target]; 
    }
    
}

