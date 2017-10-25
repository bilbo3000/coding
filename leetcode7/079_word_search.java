/*
Search a word within a matrix. 

Solve it recursively. 
At beginning of recursive call, set the character to '.'; 
Then try to move to four directions. 
** Check before going in.**
Restore current character before return. 

Time: O(mnL), where L is the length of the word; 
Space: O(L), cause the deepest call stack would be the length of word;
*/ 
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false; 
        }
        
        int m = board.length; 
        int n = board[0].length; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (visit(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
            
        return false; 
    }
    
    private boolean visit(char[][] board, int i, int j, String word, int k) {
        if (k == word.length() - 1) {
            return true; 
        }
        
        // Backup current character, which should be the same as word.charAt(k)
        char temp = board[i][j];
        board[i][j] = '.'; 
        int m = board.length; 
        int n = board[0].length;
        
        // Try to move to four adjancent directions
        boolean result = false; 
        
        // Try to move to right
        if (j < n - 1 && board[i][j + 1] == word.charAt(k + 1)) {
            result = visit(board, i, j + 1, word, k + 1);
        }
        
        // Try to move down
        if (!result && i < m - 1 && board[i + 1][j] == word.charAt(k + 1)) {
            result = visit(board, i + 1, j, word, k + 1);
        }
        
        // Try to move left
        if (!result && j > 0 && board[i][j - 1] == word.charAt(k + 1)) {
            result = visit(board, i, j - 1, word, k + 1);
        }
        
        // Try to move up 
        if (!result && i > 0 && board[i - 1][j] == word.charAt(k + 1)) {
            result = visit(board, i - 1, j, word, k + 1);
        }
        
        // Restore before return
        board[i][j] = temp; 
        
        return result; 
    }
}
