class Solution {
public:
    bool isPalindrome(string s) {
        if (s.size() == 0 || s.size() == 1) {
            return true; 
        }
        
        int i = 0; 
        int j = s.size() - 1; 
        
        while (i <= j) {
            if (s[i] == s[j]) {
                i++; 
                j--; 
            }
            else {
                return false; 
            }
        }
        
        return true; 
    }
    
    void partitionHelper(string s, vector<string> output, vector<vector<string> > &result) {
        if (s.size() == 0) {
            result.push_back(output); 
            return; 
        }
        
        for (int i = 0; i < s.size(); i++) {
            string temp = s.substr(0, i + 1);
            if (isPalindrome(temp)) {
                output.push_back(temp); 
                partitionHelper(s.substr(i + 1), output, result); 
                output.pop_back(); 
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<vector<string> > result; 
        if (s.size() == 0) {
            return result; 
        }
        vector<string> output; 
        
        partitionHelper(s, output, result); 
        
        return result; 
    }
};
