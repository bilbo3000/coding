class Solution {
public:
    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        int n = s.size(); 
        vector<vector<int> > T(n);  // T[i]: the sentences formed by first ith letter in s
        for (int i = 0; i < n; i++) {
            vector<int> temp; 
            T[i] = temp; 
        }
        
        for (int i = 0; i < n; i++) {
            int j = i; 
            
            while (j >= 0) {
                string seg = s.substr(j, i - j + 1); 
                
                if (dict.find(seg) != dict.end()) {
                    T[i].push_back(j); 
                }
                
                j--; 
            }
        }
        
        vector<string> result; 
        vector<string> sen; 
        
        dfs(T, n - 1, result, sen, s); 
        
        return result; 
    }
    
    void dfs(vector<vector<int> > T, int currIndex, vector<string> &result, vector<string> &sen, string s) {
        if (currIndex == -1) {
            string line = sen[0]; 
            
            for (int i = 1; i < sen.size(); i++) {
                line += " " + sen[i]; 
            }
            
            result.push_back(line); 
        }
        else {
            for (int i = 0; i < T[currIndex].size(); i++) {
                int index = T[currIndex][i]; 
                string word = s.substr(index, currIndex - index + 1); 
                sen.insert(sen.begin(), word); 
                dfs(T, index - 1, result, sen, s); 
                sen.erase(sen.begin()); 
            }
        }
    }
};
