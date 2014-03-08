#include <iostream> 
#include <vector> 
#include <algorithm> 

using namespace std; 

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int n = prices.size(); 
        if (n == 0 || n == 1) {
            return 0; 
        }
        
        if (n == 2) {
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;  
        }
        
        vector<int> history;  // The max profit before current point 
        vector<int> future;   // The max profit after current point 
        history.assign(n, 0);
        future.assign(n, 0);  
        int min = prices[0]; 
        int max = prices[n - 1]; 
        
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i]; 
            }
            
            if (i > 0) {
                history[i] = history[i - 1] > prices[i] - min ? history[i - 1] : prices[i] - min; 
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i]; 
            }
            
            if (i < n - 1) {
                future[i] = future[i + 1] > max - prices[i] ? future[i + 1] : max - prices[i]; 
            }
        }
        
        int maxProfit = 0; 
        for (int i = 0; i < n; i++) {
            maxProfit = maxProfit > history[i] + future[i] ? maxProfit : history[i] + future[i]; 
        }
        
        return maxProfit; 
    }
};

int main() {
    Solution sln; 
    vector<int> vec; 
    vec.push_back(1);
    vec.push_back(2); 
    vec.push_back(4);  
    
    cout << sln.maxProfit(vec) << endl;  
    return 0; 
}
