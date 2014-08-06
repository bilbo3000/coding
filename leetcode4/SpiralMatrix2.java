public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        if (n == 0) {
            return result;     
        }
        
        moveRight(0, 0, 0, 1, n, result);
        
        return result; 
    }
    
    private void moveRight(int x, int y, int level, int cnt, int n, int[][] result) {
        result[x][y] = cnt; 
        
        if (y < n - 1 - level) {
            moveRight(x, y + 1, level, cnt + 1, n, result); 
        } else if (x < n - 1 - level) {
            moveDown(x + 1, y, level, cnt + 1, n, result); 
        }
    }
    
    private void moveDown(int x, int y, int level, int cnt, int n, int[][] result) {
        result[x][y] = cnt; 
        
        if (x < n - 1 - level) {
            moveDown(x + 1, y, level, cnt + 1, n, result); 
        } else if (y > level) {
            moveLeft(x, y - 1, level, cnt + 1, n, result); 
        }
    }
    
    private void moveLeft(int x, int y, int level, int cnt, int n, int[][] result) {
        result[x][y] = cnt; 
        
        if (y > level) {
            moveLeft(x, y - 1, level, cnt + 1, n, result); 
        } else if (x > level + 1) {
            moveUp(x - 1, y, level, cnt + 1, n, result); 
        }
    }
    
    private void moveUp(int x, int y, int level, int cnt, int n, int[][] result) {
        result[x][y] = cnt; 
        
        if (x > level + 1) {
            moveUp(x - 1, y, level, cnt + 1, n, result); 
        } else if (y < n - 2 - level) {
            moveRight(x, y + 1, level + 1, cnt + 1, n, result); 
        }
    }
}
