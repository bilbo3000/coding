/**
 * Traverse the matrix in spiral order. 
 * The idea was to implement moveRight, moveDown, moveLeft, and moveUp
 * methods, and maintain a separate boolean matrix to keep track of 
 * which cell has been visited. At each step, use the current move and 
 * the boolean matrix to determine which direction to move next. 
 */ 
public class Solution {
    private List<Integer> result = new ArrayList<>(); 
    private int m = 0; 
    private int n = 0; 
    private boolean[][] flag; 
    private int[][] matrix; 
    
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix; 
        m = matrix.length; 
        
        if (m == 0) {
            return result; 
        }
        
        n = matrix[0].length; 
        
        if (n == 0) {
            return result; 
        }
        
        flag = new boolean[m][n]; 
        
        moveRight(0, 0);
        
        return result; 
    }
    
    private void moveRight(int i, int j) {
        result.add(matrix[i][j]); 
        flag[i][j] = true; 
        
        if (j < n - 1 && !flag[i][j + 1]) {
            moveRight(i, j + 1); 
        } else if (i < m - 1 && !flag[i + 1][j]) {
            moveDown(i + 1, j); 
        }
    }
    
    private void moveDown(int i, int j) {
        result.add(matrix[i][j]); 
        flag[i][j] = true; 
        
        if (i < m - 1 && !flag[i + 1][j]) {
            moveDown(i + 1, j); 
        } else if (j > 0 && !flag[i][j - 1]) {
            moveLeft(i, j - 1); 
        }
    }
    
    private void moveLeft(int i, int j) {
        result.add(matrix[i][j]); 
        flag[i][j] = true; 
        
        if (j > 0 && !flag[i][j - 1]) {
            moveLeft(i, j - 1); 
        } else if (i > 0 && !flag[i - 1][j]) {
            moveUp(i - 1, j); 
        }
    }
    
    private void moveUp(int i, int j) {
        result.add(matrix[i][j]); 
        flag[i][j] = true; 
        
        if (i > 0 && !flag[i - 1][j]) {
            moveUp(i - 1, j); 
        } else if (j < n - 1 && !flag[i][j + 1]) {
            moveRight(i, j + 1); 
        }
    }
}
