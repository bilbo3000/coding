public class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0; 
        if (n == 1) return 1; 
        if (n == 2) return 2; 
        
        int[] T = new int[n + 1]; 
        T[0] = 0; 
        T[1] = 1; 
        T[2] = 2; 
        
        for (int i = 3; i <= n; i++) {
            T[i] = T[i - 1] + T[i - 2]; 
        }
        
        return T[n]; 
    }
}
