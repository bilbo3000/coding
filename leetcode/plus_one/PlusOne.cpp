class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<int> result; 
        if (digits.size() == 0) {
            return result; 
        }
        
        int carry = 1; 
        
        for (int i = digits.size() - 1; i >= 0; i--) {
            int digit = (digits[i] + carry) % 10; 
            carry = (digits[i] + carry) / 10; 
            result.insert(result.begin(), digit); 
        }
        
        if (carry == 1) {
            result.insert(result.begin(), 1); 
        }
        
        return result; 
    }
};
