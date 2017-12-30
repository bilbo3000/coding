/**
 * Given a matrix. Find the length of the longest increasing path. 
 *
 * The idea was to perform dfs starting from each item and keep 
 * track of the longest increasing path. 
 *
 * Time: O(n^3), dfs is O(n^2), do n times;
 * Space: O(n^2), additional space store state; 
 */
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length; 
        int n = matrix[0].length; 
        int res = 1; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, new boolean[m][n], i, j));
            }
        }
        
        return res; 
    }
    
    private int dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        visited[i][j] = true; 
        int res = 1; 
        int m = matrix.length; 
        int n = matrix[0].length; 
        
        // left 
        if (j > 0 && !visited[i][j - 1] && matrix[i][j - 1] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, visited, i, j - 1) + 1);
        }
        
        // right
        if (j < n - 1 && !visited[i][j + 1] && matrix[i][j + 1] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, visited, i, j + 1) + 1);
        }
        
        // up
        if (i > 0 && !visited[i - 1][j] && matrix[i - 1][j] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, visited, i - 1, j) + 1);
        }
        
        // down
        if (i < m - 1 && !visited[i + 1][j] && matrix[i + 1][j] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, visited, i + 1, j) + 1);
        }
        
        visited[i][j] = false; 
        return res; 
    }
}
