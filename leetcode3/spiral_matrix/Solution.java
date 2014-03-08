public class Solution {
    private int m = 0; 
    private int n = 0; 
    private ArrayList<Integer> result = new ArrayList<Integer>(); 
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        this.m = matrix.length;
        
        if (m == 0) {
            return result; 
        }
        
        this.n = matrix[0].length; 
        
        if (n == 0) {
            return result; 
        }
        
        moveRight(matrix, 0, 0, 0); 
        
        return result; 
    }
    
    private void moveRight(int[][] matrix, int i, int j, int level) {
        result.add(matrix[i][j]);
        
        if (j < n - 1 - level) {
            moveRight(matrix, i, j + 1, level); 
        }
        else if (i < m - 1 - level) {
            moveDown(matrix, i + 1, j, level); 
        }
    }
    
    private void moveDown(int[][] matrix, int i, int j, int level) {
        result.add(matrix[i][j]); 
        
        if (i < m - 1 - level) {
            moveDown(matrix, i + 1, j, level); 
        }
        else if (j > level) {
            moveLeft(matrix, i, j - 1, level); 
        }
    }
    
    private void moveLeft(int[][] matrix, int i, int j, int level) {
        result.add(matrix[i][j]); 
        
        if (j > level) {
            moveLeft(matrix, i, j - 1, level); 
        }
        else if (i > level + 1) {
            moveUp(matrix, i - 1, j, level); 
        }
    }
    
    private void moveUp(int[][] matrix, int i, int j, int level) {
        result.add(matrix[i][j]); 
        
        if (i > level + 1) {
            moveUp(matrix, i - 1, j, level); 
        }
        else if (j < n - 1 - level - 1) {
            moveRight(matrix, i, j + 1, level + 1); 
        }
    }
}
