class Solution {
public:
    int candy(vector<int> &ratings) {
        int n = ratings.size(); 
        
        if (n == 0) {
            return 0; 
        }
        
        vector<int> candy(n, 1); 
        int sum = n; 
        
        // Scan from left to right 
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                sum -= candy[i]; 
                candy[i] = candy[i - 1] + 1; 
                sum += candy[i]; 
            }
        }
        
        // Scan from right to left 
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                sum -= candy[i]; 
                candy[i] = candy[i + 1] + 1; 
                sum += candy[i]; 
            }
        }
        
        return sum; 
    }
};
