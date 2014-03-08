public class Solution {
    public int numTrees(int n) {
        if (n == 0) return 1; 
        if (n == 1 || n == 2) return n; 
        
        int result = 0; 
        
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1); 
            int right = numTrees(n - i); 
            result += left * right; 
        }
        
        return result; 
    }
}
