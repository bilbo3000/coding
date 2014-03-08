class Solution {
public:
    int numDistinct(string S, string T) {
        int size_s = S.size(); 
        int size_t = T.size(); 
        
        if (size_s == 0 || size_t == 0) {
            return 0; 
        }
        
        int table[size_s][size_t];  // Number of distinct subsequences of T[:j] in S[:i] 
        
        for (int i = 0; i < size_s; i++) {
            for (int j = 0; j < size_t; j++) {
                table[i][j] = 0; 
            }
        }
        
        if (S[0] == T[0]) {
            table[0][0] = 1; 
        }
        
        // Initialize first column
        for (int i = 1; i < size_s; i++) {
            table[i][0] = table[i - 1][0];
            
            if (S[i] == T[0]) {
                table[i][0] += 1; 
            } 
        }
        
        for (int i = 1; i < size_s; i++) {
            for (int j = 1; j < size_t; j++) {
                table[i][j] = table[i - 1][j]; 
                
                if (S[i] == T[j]) {
                    table[i][j] += table[i - 1][j - 1]; 
                }
            }
        }
        
        return table[size_s - 1][size_t - 1]; 
    }
};
