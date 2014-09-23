public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] past = new int[len]; 
        int[] future = new int[len];
        past[0] = 0; 
        future[len - 1] = 0; 
        int min = prices[0]; 
        
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i]; 
            } 
            
            past[i] = Math.max(past[i - 1], prices[i] - min); 
        }
        
        int max = prices[len - 1]; 
        
        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i]; 
            }
                
            future[i] = Math.max(future[i + 1], max - prices[i]); 
        }
        
        int result = past[0] + future[0]; 
        
        for (int i = 1; i < len; i++) {
            if (past[i] + future[i] > result) {
                result = past[i] + future[i]; 
            }
        }
        
        return result; 
    }
}
