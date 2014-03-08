public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n]; 
        
        if (n == 0) {
            return matrix; 
        }
        
        moveRight(matrix, 0, 0, 1, 0, n); 
        
        return matrix; 
    }
    
    private void moveRight(int[][] matrix, int i, int j, int cnt, int level, int n) {
        matrix[i][j] = cnt; 
        
        if (j < n - 1 - level) {
            moveRight(matrix, i, j + 1, cnt + 1, level, n); 
        }
        else if (i < n - 1 - level) {
            moveDown(matrix, i + 1, j, cnt + 1, level, n); 
        }
    }
    
    private void moveDown(int[][] matrix, int i, int j, int cnt, int level, int n) {
        matrix[i][j] = cnt; 
        
        if (i < n - 1 - level) {
            moveDown(matrix, i + 1, j, cnt + 1, level, n); 
        }
        else if (j > level) {
            moveLeft(matrix, i, j - 1, cnt + 1, level, n); 
        }
    }
    
    private void moveLeft(int[][] matrix, int i, int j, int cnt, int level, int n) {
        matrix[i][j] = cnt; 
        
        if (j > level) {
            moveLeft(matrix, i, j - 1, cnt + 1, level, n); 
        }
        else if (i > level + 1) {
            moveUp(matrix, i - 1, j, cnt + 1, level, n); 
        }
    }
    
    private void moveUp(int[][] matrix, int i, int j, int cnt, int level, int n) {
        matrix[i][j] = cnt; 
        
        if (i > level + 1) {
            moveUp(matrix, i - 1, j, cnt + 1, level, n); 
        }
        else if (j < n - 2 - level) {
            moveRight(matrix, i, j + 1, cnt + 1, level + 1, n); 
        }
    }
}
