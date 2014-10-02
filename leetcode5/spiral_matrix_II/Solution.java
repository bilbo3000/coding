public class Solution {
    int size = 0; 
    
    public int[][] generateMatrix(int n) {
        size = n; 
        int[][] result = new int[n][n]; 
        
        if (n == 0) {
            return result; 
        }
        
        moveRight(result, 0, 0, 0, 1); 
        
        return result; 
    }
    
    private void moveRight(int[][] result, int i, int j, int index, int cnt) {
        result[i][j] = cnt; 
        
        if (j < size - 1 - index) {
            moveRight(result, i, j + 1, index, cnt + 1); 
        } else if (i < size - 1 - index) {
            moveDown(result, i + 1, j, index, cnt + 1); 
        }
    }
    
    private void moveDown(int[][] result, int i, int j, int index, int cnt) {
        result[i][j] = cnt; 
        
        if (i < size - 1 - index) {
            moveDown(result, i + 1, j, index, cnt + 1); 
        } else if (j > index) {
            moveLeft(result, i, j - 1, index, cnt + 1); 
        }
    }
    
    private void moveLeft(int[][] result, int i, int j, int index, int cnt) {
        result[i][j] = cnt; 
        
        if (j > index) {
            moveLeft(result, i, j - 1, index, cnt + 1); 
        } else if (i > index + 1) {
            moveUp(result, i - 1, j, index, cnt + 1); 
        }
    }
    
    private void moveUp(int[][] result, int i, int j, int index, int cnt) {
        result[i][j] = cnt; 
        
        if (i > index + 1) {
            moveUp(result, i - 1, j, index, cnt + 1); 
        } else if (j < size - index - 2) {
            moveRight(result, i, j + 1, index + 1, cnt + 1); 
        }
    }
}
