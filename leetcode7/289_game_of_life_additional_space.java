/**
 * Rules: 
 * 1) live cell with fewer than 2 live neighbors dies; 
 * 2) live cell with 2 or 3 live neighbors lives; 
 * 3) live cell with more than 3 live neighbors dies; 
 * 4) dead cell with 3 live neighbors lives; 
 * 
 * This solution uses O(n^2) spaces to store state. 
 * Time is O(n^2). 
 */
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
        	return; 
        }
        
        int m = board.length; 
        int n = board[0].length; 
        int[][] state = new int[m][n];
        
        // Copy over states
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		state[i][j] = board[i][j]; 
        	}
        }
        
        // Update board
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int count = check(state, i, j);
        		
        		if (board[i][j] == 1 && count < 2) {
        			board[i][j] = 0; 
        			continue; 
        		}
        		
        		if (board[i][j] == 1 && (count == 2 || count == 3)) {
        			continue; 
        		}
        		
        		if (board[i][j] == 1 && count > 3) {
        			board[i][j] = 0; 
        			continue; 
        		}
        		
        		if (board[i][j] == 0 && count == 3) {
        			board[i][j] = 1; 
        			continue; 
        		}
        	}
        }
    }
    
    private int check(int[][] state, int i, int j) {
    	int m = state.length; 
        int n = state[0].length;
        int count = 0; 
        
        // Check vertical
        if (i > 0 && state[i - 1][j] == 1) {
        	 count++;
        }
        
        if (i < m - 1 && state[i + 1][j] == 1) {
        	count++;
        }
        
        // Check horizontal
        if (j > 0 && state[i][j - 1] == 1) {
        	count++; 
        }
        
        if (j < n - 1 && state[i][j + 1] == 1) {
        	count++; 
        }
        
        // Check diagonals
        if (i > 0 && j > 0 && state[i - 1][j - 1] == 1) {
        	count++; 
        }
        
        if (i > 0 && j < n - 1 && state[i - 1][j + 1] == 1) {
        	count++; 
        }
        
        if (i < m - 1 && j > 0 && state[i + 1][j - 1] == 1) {
        	count++; 
        }
        
        if (i < m - 1 && j < n - 1 && state[i + 1][j + 1] == 1) {
        	count++; 
        }
        	
        return count; 
    }
}
