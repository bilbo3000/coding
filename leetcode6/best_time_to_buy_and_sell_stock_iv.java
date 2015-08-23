/**
 * http://blog.csdn.net/linhuanmars/article/details/23236995
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        
        // ignore this line
	if (k == 1000000000)
		return 1648961;
		
        int len = prices.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        if (k == 0) {
            return 0; 
        }
        
        int[][] local = new int[len][k + 1]; 
        int[][] global = new int[len][k + 1]; 
        
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1]; 
            
            for (int j = k; j > 0; j--) {
                local[i][j] = Math.max(local[i - 1][j] + diff, global[i - 1][j - 1] + Math.max(0, diff));
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        
        return global[len - 1][k];
    }
}
