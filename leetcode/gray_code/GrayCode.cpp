class Solution {
public:
    int binaryStringToInt(string s) {
        int result = 0; 
        for (int i = 0; i < s.size(); i++) {
            int digit = s[i] - '0'; 
            result = result << 1; 
            result += digit; 
        }
        
        return result; 
    }
    
    vector<int> grayCode(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<int> result;
        if (n == 0) {
            result.push_back(0);
            return result; 
        }
        
        vector<string> temp; 
        temp.push_back("0");
        temp.push_back("1"); 
        
        for (int i = 1; i < n; i++) {
            for (int j = temp.size() - 1; j >= 0; j--) {
                temp.push_back(temp[j]);   // Mirror
            }
            
            int mid = temp.size() / 2; 
            for (int j = 0; j < temp.size(); j++) {
                if (j < mid) {
                    temp[j] = "0" + temp[j]; 
                }
                else {
                    temp[j] = "1" + temp[j]; 
                }
            }
        }
        
        for (int i = 0; i < temp.size(); i++) {
            result.push_back(binaryStringToInt(temp[i])); 
        }
        
        return result; 
    }
};
