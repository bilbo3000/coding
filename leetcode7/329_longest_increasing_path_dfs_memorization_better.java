/**
 * Given a matrix, find the longest increasing path. 
 * 
 * DFS on each cell and memorize the max return from each DFS call in mem[i][j]. 
 * 
 * The trick here is how visited[i][j] is elimiated: only move to next item that 
 * it larger than current element. This automatically avoid going back to already 
 * visited items. 
 * 
 * Time: O(n), each item is visited once; 
 * Space: O(n), memorization; 
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
                res = Math.max(res, dfs(matrix, i, j, mem));
            }
        }
        
        return res; 
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] mem) {
    	if (mem[i][j] != 0) {
    		return mem[i][j]; 
    	}
    	
        int res = 1; 
        int m = matrix.length; 
        int n = matrix[0].length; 
        
        // left 
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, i, j - 1, mem) + 1);
        }
        
        // right
        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, i, j + 1, mem) + 1);
        }
        
        // up
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, i - 1, j, mem) + 1);
        }
        
        // down
        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) {
            res = Math.max(res, dfs(matrix, i + 1, j, mem) + 1);
        }
        
        mem[i][j] = res; 
        
        return res; 
    }
}
