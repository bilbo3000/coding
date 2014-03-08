class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int size1 = s1.size(); 
        int size2 = s2.size(); 
        int size3 = s3.size(); 
        
        if (size1 + size2 != size3) return false; 
        
        vector<vector<bool> > T; 
        
        for (int i = 0; i <= size1; i++) {
            vector<bool> temp(size2 + 1, false);
            T.push_back(temp); 
        }
        
        T[0][0] = true; 
        
        for (int i = 1; i <= size1; i++) {
            T[i][0] = T[i - 1][0] && s1[i - 1] == s3[i - 1]; 
        }
        
        for (int j = 1; j <= size2; j++) {
            T[0][j] = T[0][j - 1] && s2[j - 1] == s3[j - 1]; 
        }
        
        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (s1[i - 1] == s3[i + j - 1] && T[i - 1][j] || s2[j - 1] == s3[i + j - 1] && T[i][j - 1]) T[i][j] = true; 
                else T[i][j] = false; 
            }
        }
        
        return T[size1][size2]; 
    }
};
