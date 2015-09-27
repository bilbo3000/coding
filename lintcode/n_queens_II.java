class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    private int result = 0; 
    
    public int totalNQueens(int n) {
        //write your code here
        helper(0, new boolean[n][n]); 
        
        return result; 
    }
    
    private void helper(int row, boolean[][] board) {
        int n = board.length; 
        
        if (row == n) {
            result++; 
            return; 
        }
        
        for (int j = 0; j < n; j++) {
            if (check(row, j, board)) {
                board[row][j] = true; 
                helper(row + 1, board);
                board[row][j] = false; 
            }
        }
    }
    
    private boolean check(int row, int col, boolean[][] board) {
        int n = board.length; 
        
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                return false; 
            }
            
            int diff = Math.abs(row - i);
            
            if (col - diff >= 0 && board[i][col - diff]) {
                return false; 
            }
            
            if (col + diff < n && board[i][col + diff]) {
                return false; 
            }
        }     
        
        return true; 
    }
};


