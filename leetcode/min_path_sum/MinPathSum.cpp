class Solution {
public:
    int minPathSum(vector<vector<int> > &grid) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (grid.size() == 0) {
            return 0; 
        }
        
        int m = grid.size(); 
        int n = grid[0].size(); 
        
        if (n == 0) {
            return 0; 
        }
        
        int T[m][n];  // T[i][j]: The shortest path to grid[i][j]
        T[0][0] = grid[0][0]; 
        
        for (int i = 1; i < n; i++) {
            T[0][i] = T[0][i - 1] + grid[0][i]; 
        }
        
        for (int i = 1; i < m; i++) {
            T[i][0] = T[i - 1][0] + grid[i][0]; 
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = min(T[i][j - 1], T[i - 1][j]) + grid[i][j]; 
            }
        }
        
        return T[m - 1][n - 1]; 
    }
};
