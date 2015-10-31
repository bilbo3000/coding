class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     * 
     * O(n)
     */
    public int maxProfit(int[] prices) {
        int len = prices.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] sell = new int[len];  // Max profit if sell upto today 
        int[] buy = new int[len];  // Max profit if buy after today
        
        int min = prices[0];
        
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i]; 
                sell[i] = sell[i - 1]; 
            } else {
                sell[i] = Math.max(prices[i] - min, sell[i - 1]);
            }
        }
        
        int max = prices[len - 1]; 
        
        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i]; 
                buy[i] = buy[i + 1]; 
            } else {
                buy[i] = Math.max(buy[i + 1], max - prices[i]);
            }
        }
        
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
            if (sell[i] + buy[i] > result) {
                result = sell[i] + buy[i]; 
            }
        }
        
        return result; 
    }
};
