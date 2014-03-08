public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        int result = 0; 
        
        if (n == 0) return result; 
        
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1]; 
            }
        }
        
        return result; 
    }
}
