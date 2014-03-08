class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if (prices.size() < 2) {
            return 0; 
        } 
        
        int minIndex = 0; 
        int maxProfit = 0;
        
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i; 
            }
            else {
                if (prices[i] - prices[minIndex] > maxProfit) {
                    maxProfit = prices[i] - prices[minIndex];
                }
            }
        }
        
        return maxProfit; 
    }
};
