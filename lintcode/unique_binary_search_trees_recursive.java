public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     * 
     * Recursive solution. 
     * Time complexity?
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 1; 
        }
        
        return helper(n, new int[n]);
    }
    
    private int helper(int n, int[] history) {
        if (n == 0) {
            history[0] = 1;
            return 1; 
        }
        
        if (history[n - 1] != 0) {
            return history[n - 1]; 
        }

        int count = 0; 
        
        for (int i = 1; i <= n; i++) {
            int left = helper(i - 1, history);
            int right = helper(n - i, history);

            count += left * right;
        }
        
        history[n - 1] = count;
        
        return count;
    }
}
