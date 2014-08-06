public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>(); 
        int m = matrix.length; 
        
        if (m == 0) {
            return result; 
        }
        
        int n = matrix[0].length; 
        
        if (n == 0) {
            return result; 
        }
        
        for (int level = 0; level < (Math.min(m, n) + 1) / 2; level++) {
            moveRight(matrix, level, level, level, m, n, result); 
        }
        
        return result; 
    }
    
    private void moveRight(int[][] matrix, int x, int y, int level, int m, int n, List<Integer> result) {
        result.add(matrix[x][y]);
        
        if (y < n - 1 - level) {
            moveRight(matrix, x, y + 1, level, m, n, result); 
        } else if (x < m - 1 - level) {
            moveDown(matrix, x + 1, y, level, m, n, result); 
        }
    }
    
    private void moveDown(int[][] matrix, int x, int y, int level, int m, int n, List<Integer> result) {
        result.add(matrix[x][y]); 
        
        if (x < m - 1 - level) {
            moveDown(matrix, x + 1, y, level, m, n, result); 
        } else if (y > level) {
            moveLeft(matrix, x, y - 1, level, m, n, result); 
        }
    }
    
    private void moveLeft(int[][] matrix, int x, int y, int level, int m, int n, List<Integer> result) {
        result.add(matrix[x][y]);
        
        if (y > level) {
            moveLeft(matrix, x, y - 1, level, m, n, result); 
        } else if (x > level + 1) {
            moveUp(matrix, x - 1, y, level, m, n, result); 
        }
    }
    
    private void moveUp(int[][] matrix, int x, int y, int level, int m, int n, List<Integer> result) {
        result.add(matrix[x][y]); 
        
        if (x > level + 1) {
            moveUp(matrix, x - 1, y, level, m, n, result); 
        }
    }
}
