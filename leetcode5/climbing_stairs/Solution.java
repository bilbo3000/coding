public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0; 
        }
        
        if (n == 1 || n == 2) {
            return n; 
        }
        
        int[] T = new int[n];
        T[0] = 1; 
        T[1] = 2; 
        
        for (int i = 2; i < n; i++) {
            T[i] = T[i - 1] + T[i - 2];
        }
        
        return T[n - 1]; 
    }
}
