public class Solution {
    private int m = 0; 
    private int n = 0; 
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>(); 
        m = matrix.length; 
        
        if (m == 0) {
            return result; 
        }
        
        n = matrix[0].length; 
        
        if (n == 0) {
            return result; 
        }
        
        moveRight(matrix, 0, 0, 0, result); 
        
        return result; 
    }
    
    private void moveRight(int[][] matrix, int i, int j, int index, List<Integer> result) {
        result.add(matrix[i][j]); 
        
        if (j < n - index - 1) {
            moveRight(matrix, i, j + 1, index, result); 
        } else if (i < m - index - 1) {
            moveDown(matrix, i + 1, j, index, result); 
        }
    }
    
    private void moveDown(int[][] matrix, int i, int j, int index, List<Integer> result) {
        result.add(matrix[i][j]); 
        
        if (i < m - index - 1) {
            moveDown(matrix, i + 1, j, index, result); 
        } else if (j > index) {
            moveLeft(matrix, i, j - 1, index, result); 
        }
    }
    
    private void moveLeft(int[][] matrix, int i, int j, int index, List<Integer> result) {
        result.add(matrix[i][j]); 
        
        if (j > index) {
            moveLeft(matrix, i, j - 1, index, result); 
        } else if (i > index + 1) {
            moveUp(matrix, i - 1, j, index, result); 
        }
    }
    
    private void moveUp(int[][] matrix, int i, int j, int index, List<Integer> result) {
        result.add(matrix[i][j]);
        
        if (i > index + 1) {
            moveUp(matrix, i - 1, j, index, result); 
        } else if (j < n - index - 2) {
            moveRight(matrix, i, j + 1, index + 1, result); 
        }
    }
}
