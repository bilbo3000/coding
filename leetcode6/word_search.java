/**
 * Search a given word in a board. 
 * Solve it recursively. Set the current char in board to '.' before moving to 
 * next cell and reset it back upon return. Don't forget the base case where 
 * the last char matches and no other direction to go, then we need to return true. 
 */ 
public class Solution {
    private int m = 0; 
    private int n = 0; 
    
    public boolean exist(char[][] board, String word) {
        m = board.length; 
        
        if (m == 0) {
            return false; 
        }
        
        n = board[0].length; 
        
        if (n == 0) {
            return false;
        }
        
        if (word.length() == 0) {
            return false; 
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = helper(board, i, j, word, 0); 
                    
                    if (result) {
                        return true; 
                    }
                }
            }
        }
        
        return false; 
    }
    
    private boolean helper(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true; 
        }
        
        if (word.charAt(index) != board[row][col]) {
            return false; 
        }
        
        if (word.charAt(index) == board[row][col] && index == word.length() - 1) {
            return true; 
        }
        
        char temp = board[row][col]; 
        board[row][col] = '.'; 
        boolean result = false; 
        
        if (!result && col < n - 1) {
            result = helper(board, row, col + 1, word, index + 1); 
        }
        
        if (!result && row < m - 1) {
            result = helper(board, row + 1, col, word, index + 1); 
        }
        
        if (!result && col > 0) {
            result = helper(board, row, col - 1, word, index + 1); 
        }
        
        if (!result && row > 0) {
            result = helper(board, row - 1, col, word, index + 1); 
        }
        
        board[row][col] = temp; 
        
        return result; 
    }
}
