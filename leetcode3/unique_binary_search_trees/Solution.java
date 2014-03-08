public class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0; 
        }
        
        if (n == 1) {
            return 1; 
        }
        
        int result = 0; 
        
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1); 
            int right = numTrees(n - i); 
            
            if (left != 0 && right != 0) {
                result += left * right; 
            }
            else {
                result += left + right; 
            }
        }
        
        return result; 
    }
}
