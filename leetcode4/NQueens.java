public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>(); 
        
        if (n == 0) {
            return result; 
        }
        
        boolean[][] board = new boolean[n][n]; 
        helper(board, 0, result); 
        
        return result; 
    }
    
    private void helper(boolean[][] board, int row, List<String[]> result) {
        int n = board.length; 
        if (row == n) {
            String[] sol = new String[n]; 
            for (int i = 0; i < n; i++) {
                String rowStr = ""; 
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        rowStr += "Q"; 
                    } else {
                        rowStr += "."; 
                    }
                }
                
                sol[i] = rowStr;
            }
            result.add(sol);
            return; 
        } else {
            for (int j = 0; j < n; j++) {
                if (checkAbove(board, row, j)) {
                    board[row][j] = true; 
                    helper(board, row + 1, result);
                    board[row][j] = false; 
                }
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
