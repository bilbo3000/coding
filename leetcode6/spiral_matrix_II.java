/**
 * Fill a square matrix in spiral order. 
 * The ideas was to implement moveRight, moveDown, moveLeft, and moveRight
 * methods. Each time when move to next direction, increase the value by 1.
 */ 
public class Solution {
    private int[][] matrix; 
    private int n; 
    
    public int[][] generateMatrix(int n) {
        this.n = n; 
        
        if (n == 0) {
            return new int[n][n]; 
        }
        
        this.matrix = new int[n][n]; 
        
        moveRight(0, 0, 1); 
        
        return matrix; 
    }
    
    private void moveRight(int i, int j, int val) {
        matrix[i][j] = val; 
        
        if (j < n - 1 && matrix[i][j + 1] == 0) {
            moveRight(i, j + 1, val + 1); 
        } else if (i < n - 1 && matrix[i + 1][j] == 0) {
            moveDown(i + 1, j, val + 1); 
        }
    }
    
    private void moveDown(int i, int j, int val) {
        matrix[i][j] = val; 
        
        if (i < n - 1 && matrix[i + 1][j] == 0) {
            moveDown(i + 1, j, val + 1); 
        } else if (j > 0 && matrix[i][j - 1] == 0) {
            moveLeft(i, j - 1, val + 1); 
        }
    }
    
    private void moveLeft(int i, int j, int val) {
        matrix[i][j] = val; 
        
        if (j > 0 && matrix[i][j - 1] == 0) {
            moveLeft(i, j - 1, val + 1); 
        } else if (i > 0 && matrix[i - 1][j] == 0) {
            moveUp(i - 1, j, val + 1); 
        }
    }
    
    private void moveUp(int i, int j, int val) {
        matrix[i][j] = val; 
        
        if (i > 0 && matrix[i - 1][j] == 0) {
            moveUp(i - 1, j, val + 1); 
        } else if (j < n - 1 && matrix[i][j + 1] == 0) {
            moveRight(i, j + 1, val + 1); 
        }
    }
}
