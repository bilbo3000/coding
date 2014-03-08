public class Solution {
    private ArrayList<Integer> result = new ArrayList<Integer>(); 
    private int m = 0; 
    private int n = 0; 
    private int[][] matrix; 
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length; 
        
        if (m == 0) return result; 
        
        n = matrix[0].length; 
        
        if (n == 0) return result; 
        
        this.matrix = matrix; 
        
        for (int level = 0; level < (Math.min(m, n) + 1) / 2; level++) {
            moveRight(level, level, level); 
        } 
        
        return result; 
    }
    
    private void moveRight(int x, int y, int level) {
        result.add(matrix[y][x]);
        
        if (x < n - 1 - level) {
            moveRight(x + 1, y, level); 
        }
        else if (y < m - 1 - level){
            moveDown(x, y + 1, level); 
        }
    }
    
    private void moveDown(int x, int y, int level) {
        result.add(matrix[y][x]); 
        
        if (y < m - 1 - level) {
            moveDown(x, y + 1, level); 
        }
        else if (x > level) {
            moveLeft(x - 1, y, level); 
        }
    }
    
    private void moveLeft(int x, int y, int level) {
        result.add(matrix[y][x]);
        
        if (x > level) {
            moveLeft(x - 1, y, level); 
        }
        else if (y > level + 1) {
            moveUp(x, y - 1, level); 
        }
    }
    
    private void moveUp(int x, int y, int level) {
        result.add(matrix[y][x]); 
        
        if (y > level + 1) {
            moveUp(x, y - 1, level); 
        }
    }
}
