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
        
        char firstChar = word.charAt(0); 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == firstChar) {
                    boolean result = helper(board, i, j, word, 0); 
                    
                    if (result) {
                        return true; 
                    }
                }
            }
        }
        
        return false; 
    }
    
    private boolean helper(char[][] board, int i, int j, String word, int index) {
        int len = word.length(); 
        
        if (index == len - 1) {
            return true; 
        }
        
        char save = board[i][j]; 
        board[i][j] = '.'; 
        boolean result = false; 
        char next = word.charAt(index + 1); 
        
        if (j < n - 1 && board[i][j + 1] == next) {
            result = helper(board, i, j + 1, word, index + 1); 
        }
        
        if (!result && i < m - 1 && board[i + 1][j] == next) {
            result = helper(board, i + 1, j, word, index + 1); 
        }
        
        if (!result && i > 0 && board[i - 1][j] == next) {
            result = helper(board, i - 1, j, word, index + 1); 
        }
        
        if (!result && j > 0 && board[i][j - 1] == next) {
            result = helper(board, i, j - 1, word, index + 1); 
        }
        
        board[i][j] = save; 
        
        return result; 
    }
}
