/**
 * Find all possible N-Queue configurations for the board with given size. 
 * Solve it recursively. The idea was to implement a check function verifies 
 * whether it is valid to place a queue at current position. If invalid, 
 * backtrack and try next position. If valid, then place the Quene at current 
 * position and move on to next row. If it finishes placing Queue in all rows, 
 * it means we found a solution. Store the solution ready to return. 
 * The observation is that each row can only contain one queue, thus after 
 * placing a queue at current row, we can savefully move on to next row. 
 * Also remember to reset the Q back to . during back tracking. 
 */
public class Solution {
    private int n; 
    private List<List<String>> result = new ArrayList<List<String>>(); 
    
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

    public List<List<String>> solveNQueens(int n) {
        this.n = n; 
        
        if (n <= 0) {
            return result; 
        }
        
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
            List<String> temp = new ArrayList<>(); 
            
            for (int i = 0; i < n; i++) {
                temp.add(String.valueOf(board[i])); 
            }
            
            result.add(temp); 
            
            return; 
    	}
    	
        for (int j = 0; j < n; j++) {
            board[row][j] = 'Q'; 
            boolean flag = check(board, row, j);
            
            if (flag) {
            	helper(board, row + 1); 
            } 
            
            board[row][j] = '.'; 
        }
    }
}
