public class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0; 
        }
        
        if (n == 1) {
            return 1; 
        }
        
        int count = 0; 
        
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                count += numTrees(n - 1); 
            }
            else if (i == n) {
                count += numTrees(n - 1); 
            }
            else {
                count += numTrees(i - 1) * numTrees(n - i); 
            }
        }
        
        return count; 
    }
}
