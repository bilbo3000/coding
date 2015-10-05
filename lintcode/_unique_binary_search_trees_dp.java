public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     * 
     * Dynamic programming solution. 
     * T[i]: the number of unique binary trees for i elements. 
     * Build T[i] from bottom up. 
     * T[i] = sum(T[1..k - 1] * T[k + 1..i], where 1 <= k <= i).
     * 
     * O(n^2)
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 1; 
        }
        
        // T[i]: number of unique binary search trees for i elements 
        int[] T = new int[n + 1];
        T[0] = 1; 
        T[1] = 1; 
        
        for (int i = 2; i <= n; i++) {
            int count = 0; 
            
            for (int j = 1; j <= i; j++) {
                // j is the root
                count += T[j - 1] * T[i - j]; 
            }
            
            T[i] = count; 
        }
        
        return T[n]; 
    }
}
