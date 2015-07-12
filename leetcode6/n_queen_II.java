/**
 * Find the number of distinct n-queen configurations for the board with given size. 
 * Solve it recursively. The core idea was that for a given row, there can only be 
 * one queen. Once placed a queue for a row, we can safely move onto next row. 
 * Also need to implement a check function that verifies whether place a queen at 
 * the current position is valid. If invalid, backtrack and try next position in this 
 * row if possible. If valid, move onto next row starting from the beginning. Also 
 * remember to reset the Q to . during backtracking. 
 */ 
public class Solution {
    private int result; 
    private int n; 
    
    public int totalNQueens(int n) {
        this.n = n; 
        char[][] board = new char[n][n]; 
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; 
            }
        }
        
        helper(board, 0); 
        
        return result; 
    }
    
    private void helper(char[][] board, int row) {
        if (row == n) {
            result++; 
            return; 
        }
        
        for (int j = 0; j < n; j++) {
            board[row][j] = 'Q'; 
            
            if (check(board, row, j)) {
                helper(board, row + 1); 
            }
            board[row][j] = '.'; 
        }
    }
    
    private boolean check(char[][] board, int row, int col) {
        if (row == 0) {
            return true; 
        }
        
        for (int i = row - 1; i >= 0; i--) {
            // Check column
            if (board[i][col] == 'Q') {
                return false; 
            }
            
            // Check diagonal 
            if (col - row + i >= 0 && board[i][col - row + i] == 'Q') {
                return false; 
            }
            
            if (col + row - i < n && board[i][col + row - i] == 'Q') {
                return false; 
            }
        }
        
        return true; 
    }
}
