public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length; 
        
        if (m == 0) {
            return false; 
        }
        
        int n = board[0].length; 
        
        if (n == 0) {
            return false; 
        }
        
        boolean result = false; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = helper(board, word, i, j, 0); 
                
                if (result) {
                    return true;  
                }
            }
        }
        
        return false;  
    }
    
    private boolean helper(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true; 
        }
        
        int m = board.length; 
        int n = board[0].length;
        
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false; 
        }
        
        if (board[x][y] != word.charAt(index)) {
            return false; 
        }
        
        char temp = board[x][y]; 
        board[x][y] = '+'; 
        boolean result = false; 
        
        result = helper(board, word, x, y + 1, index + 1); 
        
        if (!result) {
            result = helper(board, word, x + 1, y, index + 1); 
        }
        
        if (!result) {
            result = helper(board, word, x, y - 1, index + 1); 
        }
        
        if (!result) {
            result = helper(board, word, x - 1, y, index + 1); 
        }
        
        board[x][y] = temp; 
        
        return result; 
    }
}
