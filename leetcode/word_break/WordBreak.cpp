class Solution {
public:
    bool wordBreak(string s, unordered_set<string> &dict) {
        if (s.size() == 0) return false; 
        
        vector<bool> T(s.size() + 1, false);  // T[i]: whether the first i letters can be segmented. 
        T[0] = true; 
        
        for (int i = 1; i <= s.size(); i++) {
            int j = i; 
            
            while (j >= 1) {
                string postfix = s.substr(j - 1, i - j + 1); 
                
                if (dict.find(postfix) != dict.end() && T[j - 1]) {
                    T[i] = true; 
                    break; 
                }
                
                j--;
            }
        }
        
        return T[s.size()]; 
    }
};
