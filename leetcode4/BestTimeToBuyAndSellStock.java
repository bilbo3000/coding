public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int len = prices.length; 
        
        if (len < 2) {
            return maxProfit; 
        }
        int low = prices[0]; 
        
        for (int i = 1; i < len; i++) {
            if (prices[i] < low) {
                low = prices[i]; 
            }
            
            maxProfit = Math.max(maxProfit, prices[i] - low); 
        }
        
        return maxProfit; 
    }
}
