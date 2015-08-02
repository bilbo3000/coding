/**
 * Check if a given sudoku is valid. 
 * Implement three methods: check a given row; check a given col; 
 * check a given quadrant. 
 */ 
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean result = true; 
        
        // Check rows & cols
        for (int a = 0; a < 9; a++) {
            result = checkRow(a, board);
            
            if (!result) {
                return false; 
            }
            
            result = checkCol(a, board);
            
            if (!result) {
                return false; 
            }
        }
        
        // Check quad
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                result = checkQuad(a, b, board);
                
                if (!result) {
                    return false; 
                }
            }
        }
        
        return true; 
    }
    
    private boolean checkRow(int row, char[][] board) {
        boolean[] arr = new boolean[9];
        
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == '.') continue; 
            int index = (int)(board[row][j] - '0') - 1; 
            
            if (arr[index]) {
                return false; 
            }
            
            arr[index] = true; 
        }
        
        return true; 
    }
    
    private boolean checkCol(int col, char[][] board) {
        boolean[] arr = new boolean[9];
        
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') continue; 
            int index = (int)(board[i][col] - '0') - 1;
            
            if (arr[index]) {
                return false; 
            }
            
            arr[index] = true; 
        }
        
        return true; 
    }
    
    private boolean checkQuad(int i, int j, char[][] board) {
        boolean[] arr = new boolean[9]; 
        
        for (int r = i * 3; r < i * 3 + 3; r++) {
            for (int c = j * 3; c < j * 3 + 3; c++) {
                if (board[r][c] == '.') continue; 
                int index = (int)(board[r][c] - '0') - 1; 
                
                if (arr[index]) {
                    return false; 
                }
                
                arr[index] = true; 
            }
        }
        
        return true; 
    }
}
