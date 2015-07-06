/**
 * If only be able to buy and sell a stock once, find the max return. 
 * The idea is to walk through the price list and maintain a minimum value. 
 * Update the current value accordingly if the current element is less 
 * than the current min value. Otherwise, calculate the gain between current
 * value and min. Update the max gain accordingly. 
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length; 
        
        if (len <= 1) {
            return 0; 
        }
        
        int min = prices[0]; 
        int result = 0; 
        
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i]; 
            } else {
                result = Math.max(result, prices[i] - min); 
            }
        }
        
        return result; 
    }
}
