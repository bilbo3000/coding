#include <iostream> 

using namespace std; 

class Solution {
public:
    int min(int a, int b, int c) {
        int min = a; 
        if (b < min) {
            min = b; 
        }
        
        if (c < min) {
            min = c; 
        }
        
        return min; 
    }
    
    int minDistance(string word1, string word2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        int T[word1.size() + 1][word2.size() + 1];  // T[i][j]: edit distance of first ith word1 and first jth word2
        
        T[0][0] = 0; 
        
        // Initialize first row
        for (int i = 1; i <= word2.size(); i++) {
            T[0][i] = T[0][i - 1] + 1; 
        }
        
        // Initialize first column
        for(int i = 1; i <= word1.size(); i++) {
            T[i][0] = T[i - 1][0] + 1; 
        }
        
        for (int i = 1; i <= word1.size(); i++) {
            for (int j = 1; j <= word2.size(); j++) {
                if (word1[i - 1] == word2[j - 1]) {
                    T[i][j] = min(T[i - 1][j - 1], T[i - 1][j] + 1, T[i][j - 1] + 1);  
                }
                else {
                    T[i][j] = min(T[i - 1][j - 1] + 1, T[i - 1][j] + 1, T[i][j - 1] + 1); 
                }
            }
        }
        
        return T[word1.size()][word2.size()];
    }
};

// Test Driver 
int main() {
    Solution sln; 
    cout << sln.minDistance("sea", "eat") << endl; 
    return 0; 
}
