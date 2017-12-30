/**
 * Given a matrix, find the longest increasing path.
 * 
 * Run dfs for each item. Use additional matrix mem[i][j] to keep track 
 * of the longest path starting from matrix[i][j]. --> no need to calcualte 
 * multiple times. 
 * 
 * Time: O(n), each cell is caculated once. 
 * Space: O(n)
 */
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length; 
        int n = matrix[0].length; 
        int res = 1; 
        int[][] mem = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, new boolean[m][n], i, j, mem));
            }
        }
        
        return res; 
    }
    
    private int dfs(int[][] matrix, boolean[][] visited, int i, int j, int[][] mem) {
    	if (mem[i][j] != 0) {
    		return mem[i][j]; 
    	}
    	
        visited[i][j] = true; 
        int res = 1; 
        int m = matrix.length; 
        int n = matrix[0].length; 
        
        // left 
        if (j > 0 && !visited[i][j - 1] && matrix[i][j - 1] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, visited, i, j - 1, mem) + 1);
        }
        
        // right
        if (j < n - 1 && !visited[i][j + 1] && matrix[i][j + 1] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, visited, i, j + 1, mem) + 1);
        }
        
        // up
        if (i > 0 && !visited[i - 1][j] && matrix[i - 1][j] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, visited, i - 1, j, mem) + 1);
        }
        
        // down
        if (i < m - 1 && !visited[i + 1][j] && matrix[i + 1][j] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, visited, i + 1, j, mem) + 1);
        }
        
        visited[i][j] = false; 
        mem[i][j] = res; 
        
        return res; 
    }
}
