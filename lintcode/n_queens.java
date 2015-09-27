class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     * 
     * O(n^n)
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>(); 
        boolean[][] board = new boolean[n][n]; 
        helper(0, board, result);
        
        return result; 
    }
    
    private void helper(int i, boolean[][] board, ArrayList<ArrayList<String>> result) {
        int n = board.length; 
        
        if (i == n) {
            // Found a solution 
            ArrayList<String> sol = new ArrayList<>(); 
            
            for (int a = 0; a < n; a++) {
                StringBuilder r = new StringBuilder(); 
                for (int b = 0; b < n; b++) {
                    if (board[a][b]) {
                        r.append("Q");
                    } else {
                        r.append(".");
                    }
                }
                sol.add(r.toString());
            }
            
            result.add(sol);
            return; 
        }
        
        // O(n^2)
        for (int j = 0; j < n; j++) {
            if (check(i, j, board)) {
                board[i][j] = true; 
                helper(i + 1, board, result);
                board[i][j] = false; 
            }
        }
    }
    // O(n)
    private boolean check(int row, int col, boolean[][] board) {
        int n = board.length; 
        
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                return false; 
            }
            
            int diff = Math.abs(i - row); 
            
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
