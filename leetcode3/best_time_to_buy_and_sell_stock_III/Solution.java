public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] history = new int[len]; 
        int[] future = new int[len]; 
        int min = prices[0]; 
        
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i]; 
                history[i] = history[i - 1]; 
            }
            else {
                history[i] = Math.max(prices[i] - min, history[i - 1]); 
            }
        }
        
        int max = prices[len - 1]; 
        
        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i]; 
                future[i] = future[i + 1]; 
            }
            else {
                future[i] = Math.max(max - prices[i], future[i + 1]); 
            }
        }
        
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
            result = Math.max(result, history[i] + future[i]); 
        }
        
        return result; 
    }
}
