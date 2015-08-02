/**
 * Solve a sudoku. 
 * Solve it recursively. Implement three methods: check current row, 
 * check current column, check given quadrant. Each recursive call, 
 * try to find the first '.', then try each number from 1 to 9 for that 
 * position. If a number pass all three checks, then keep the number at 
 * that position and recursively process the current board. If the 
 * recursive call returns false, then just try next number, until the 
 * recursive call returns true, or return false for current call. 
 */ 
public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                
                for (int k = 0; k < 9; k++) {
                    board[i][j] = (char)('1' + k);
                    boolean temp = checkRow(i, board);
                    
                    if (!temp) {
                    	board[i][j] = '.';
                        continue;  
                    }
                    
                    temp = checkCol(j, board);
                    
                    if (!temp) {
                    	board[i][j] = '.';
                        continue; 
                    }
                    
                    temp = checkQuad(i / 3, j / 3, board);
                    
                    if (!temp) {
                    	board[i][j] = '.';
                        continue;
                    }
                    
                    temp = helper(board);
                    
                    if (temp) {
                        return true; 
                    }
                    board[i][j] = '.'; 
                }
                
                return false; 
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
