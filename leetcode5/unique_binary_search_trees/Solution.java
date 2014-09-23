public class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0; 
        }
        
        if (n == 1) {
            return 1; 
        }
        
        if (n == 2) {
            return 2; 
        }
        
        int result = 0; 
        
        for (int i = 1; i <= n; i++) {
            int left = i - 1; 
            int right = n - i; 
            
            if (left == 0) {
                result += numTrees(right); 
            }
            else if (right == 0) {
                result += numTrees(left); 
            }
            else {
                result += numTrees(left) * numTrees(right); 
            }
        }
        
        return result; 
    }
}
