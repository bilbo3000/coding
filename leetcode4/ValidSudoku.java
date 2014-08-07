public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length; 
        
        if (size != 9) {
            return false; 
        }
        
        // Check rows 
        for (int i = 0; i < 9; i++) {
            boolean result = checkRow(board, i); 
            
            if (!result) {
                return false; 
            }
        }
        
        // Check cols 
        for (int j = 0; j < 9; j++) {
            boolean result = checkCol(board, j); 
            
            if (!result) {
                return false; 
            }
        }
        
        // Check quads 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean result = checkQuad(board, i, j);
                
                if (!result) {
                    return false; 
                }
            }
        }
        
        return true;
    }
    
    private boolean checkRow(char[][] board, int m) {
        boolean[] seen = new boolean[9]; 
        
        for (int j = 0; j < 9; j++) {
            if (board[m][j] == '.') {
                continue; 
            }
            
            int digit = board[m][j] - '0'; 
            
            if (digit < 1 || digit > 9) {
                return false; 
            }
            
            if (seen[digit - 1]) {
                return false; 
            } else {
                seen[digit - 1] = true; 
            }
        }
        
        return true; 
    }
    
    private boolean checkCol(char[][] board, int n) {
        boolean[] seen = new boolean[9]; 
        
        for (int i = 0; i < 9; i++) {
            if (board[i][n] == '.') {
                continue; 
            }
            
            int digit = board[i][n] - '0'; 
            
            if (digit < 1 || digit > 9) {
                return false; 
            }
            
            if (seen[digit - 1]) {
                return false;
            } else {
                seen[digit - 1] = true; 
            }
        }
        
        return true; 
    }
    
    private boolean checkQuad(char[][] board, int m, int n) {
        boolean [] seen = new boolean[9];
        
        for (int i = 3 * m; i < 3 * m + 3; i++) {
            for (int j = 3 * n; j < 3 * n + 3; j++) {
                if (board[i][j] == '.') {
                    continue; 
                }
                
                int digit = board[i][j] - '0'; 
                
                if (digit < 1 || digit > 9) {
                    return false; 
                }
                
                if (seen[digit - 1]) {
                    return false; 
                } else {
                    seen[digit - 1] = true; 
                }
            }
        }
        
        return true; 
    }
}
