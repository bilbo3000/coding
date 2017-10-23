/*
Find the number of ways to reach right bottom cells. 

Dynamic programming. 
t[i][j] = t[i - 1][j] + t[i - 1][j];

Time: O(mn)
Space: O(mn)
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n]; 
        
        // Initialize first row
        for (int j = 0; j < n; j++) {
            t[0][j] = 1; 
        }
        
        // Initialize first column
        for (int i = 0; i < m; i++) {
            t[i][0] = 1; 
        }
        
        // The rest of the cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                t[i][j] = t[i - 1][j] + t[i][j - 1];
            }
        }
        
        return t[m - 1][n - 1];
    }
}
