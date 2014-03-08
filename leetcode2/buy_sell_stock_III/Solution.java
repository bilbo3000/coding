public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        int result = 0; 
        
        if (n == 0) return result; 
        
        int [] history = new int[n]; 
        int [] future = new int[n]; 
        int min = prices[0]; 
        int max = prices[n - 1]; 
        
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) min = prices[i]; 
            
            history[i] = Math.max(history[i - 1], prices[i] - min); 
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > max) max = prices[i]; 
            
            future[i] = Math.max(future[i + 1], max - prices[i]); 
        }
        
        for (int i = 0; i < n; i++) {
            result = Math.max(result, history[i] + future[i]); 
        }
        
        return result; 
    }
}
