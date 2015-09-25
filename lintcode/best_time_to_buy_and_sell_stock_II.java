class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int len = prices.length; 
        int max = 0; 
        
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1]; 
            }
        }
        
        return max; 
    }
};
