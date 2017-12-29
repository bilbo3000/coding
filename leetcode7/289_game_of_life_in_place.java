/**
 * Rules: 
 * 1) live cell with fewer than 2 live neighbors dies; 
 * 2) live cell with 2 or 3 live neighbors lives; 
 * 3) live cell with more than 3 live neighbors dies; 
 * 4) dead cell with 3 live neighbors lives; 
 *
 * This is in place solution, where it uses -1 represents 0->1 change, 
 * and use -2 represents 1->0 change. Once finish processing all cells,
 * revert them back. 
 * 
 * Time: O(n^2)
 */
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
        	return; 
        }
        
        int m = board.length; 
        int n = board[0].length; 
        
        // Update board
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int count = check(board, i, j);
        		
        		if (board[i][j] == 1 && count < 2) {
        			board[i][j] = -2; 
        			continue; 
        		}
        		
        		if (board[i][j] == 1 && (count == 2 || count == 3)) {
        			continue; 
        		}
        		
        		if (board[i][j] == 1 && count > 3) {
        			board[i][j] = -2; 
        			continue; 
        		}
        		
        		if (board[i][j] == 0 && count == 3) {
        			board[i][j] = -1; 
        			continue; 
        		}
        	}
        }
        
        // Cleanup 
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == -1) {
        			board[i][j] = 1; 
        		} else if (board[i][j] == -2) {
        			board[i][j] = 0;
        		}
        	}
        }
    }
    
    private int check(int[][] board, int i, int j) {
    	int m = board.length; 
        int n = board[0].length;
        int count = 0; 
        
        // Check vertical
        if (i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -2)) {
        	 count++;
        }
        
        if (i < m - 1 && (board[i + 1][j] == 1 || board[i + 1][j] == -2)) {
        	count++;
        }
        
        // Check horizontal
        if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -2)) {
        	count++; 
        }
        
        if (j < n - 1 && (board[i][j + 1] == 1 || board[i][j + 1] == -2)) {
        	count++; 
        }
        
        // Check diagonals
        if (i > 0 && j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -2)) {
        	count++; 
        }
        
        if (i > 0 && j < n - 1 && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -2)) {
        	count++; 
        }
        
        if (i < m - 1 && j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -2)) {
        	count++; 
        }
        
        if (i < m - 1 && j < n - 1 && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -2)) {
        	count++; 
        }
        	
        return count; 
    }
}
