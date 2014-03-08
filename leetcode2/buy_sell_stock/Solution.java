public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0; 
        int n = prices.length; 
        
        if (n == 0) return result; 
        
        int min = prices[0]; 
        
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i]; 
            }
            else {
                result = Math.max(result, prices[i] - min); 
            }
        }
        
        return result; 
    }
}
