/**
 * If able to buy and sell stocks many times, find the maximum gain. 
 * The hint here is "you must sell before you buy". 
 * The idea was to use greedy solution. Although you must sell before 
 * you buy, for a particular stock, it is ok to sell then immediately 
 * buy at that price. Thus, we just need to walk through the input 
 * and accumulate the gain each time when there is a immediate gain 
 * between two consecutive prices. 
 */ 
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length; 
        
        if (len <= 1) {
            return 0; 
        }
        int result = 0; 
        
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1]; 
            }
        }
        
        return result; 
    }
}
