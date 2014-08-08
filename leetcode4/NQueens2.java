public class Solution {
    private int cnt = 0; 
    
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0; 
        }
        
        boolean[][] board = new boolean[n][n]; 
        helper(board, 0);
        
        return cnt; 
    }
    
    private void helper(boolean[][] board, int row) {
        int n = board.length; 
        
        if (row == n) {
            cnt++; 
        }
        
        for (int j = 0; j < n; j++) {
            if (checkAbove(board, row, j)) {
                board[row][j] = true; 
                helper(board, row + 1); 
                board[row][j] = false; 
            }
        }
    }
    
    private boolean checkAbove(boolean[][] board, int row, int col) {
        int n = board.length; 
        
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                return false; 
            }
            
            int diff = row - i; 
            
            if (col - diff >= 0 && board[i][col - diff]) {
                return false; 
            }
            
            if (col + diff < n && board[i][col + diff]) {
                return false; 
            }
        }
        
        return true; 
    }
}
