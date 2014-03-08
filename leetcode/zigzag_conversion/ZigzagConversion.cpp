class Solution {
public:
    string convert(string s, int nRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.    
        vector<vector<char> > table; 
        
        for (int i = 0; i < nRows; i++) {
            vector<char> temp; 
            table.push_back(temp); 
        }
        
        int cnt = 0; 
        bool down = true; 
        for (int i = 0; i < s.size(); i++) {
            table[cnt].push_back(s[i]); 
            if (cnt == 0) {
                down = true; 
            }
            else if (cnt == nRows - 1) {
                down = false; 
            }
            
            if (down) {
                cnt++; 
            }
            else {
                cnt--; 
            }
        }
        
        string output = ""; 
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table[i].size(); j++) {
                output += table[i][j]; 
            }
        }
        
        return output;
    }
};
