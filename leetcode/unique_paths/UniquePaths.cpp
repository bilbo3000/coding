#include <iostream> 
#include <cassert> 

using namespace std; 

class Solution {
public:
    void uniquePathsHelper(int m, int n, int row, int col, int &cnt) {
        if (row == m && col == n) {
            cnt++; 
            return; 
        }
        
        if (col < n) {
            uniquePathsHelper(m, n, row, col + 1, cnt); 
        }
        
        if (row < m) {
            uniquePathsHelper(m, n, row + 1, col, cnt); 
        }
    }
    
    int uniquePathsDP(int m, int n) {
        int T[m][n]; 
        
        for (int i = 0; i < m; i++) {
            T[i][0] = 1; 
        }
        
        for (int i = 0; i < n; i++) {
            T[0][i] = 1; 
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i - 1][j] + T[i][j - 1]; 
            }
        }
        
        return T[m - 1][n - 1]; 
    }
    
    int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int cnt = 0; 
        uniquePathsHelper(m, n, 1, 1, cnt);
        return cnt; 
    }
};

int main() {
    Solution sln; 
    assert(sln.uniquePaths(23, 12) == sln.uniquePathsDP(23, 12));  
    return 0; 
}
