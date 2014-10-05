public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) {
                return false; 
            }
        }
        
        for (int j = 0; j < 9; j++) {
            if (!checkCol(board, j)) {
                return false; 
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkQuad(board, i, j)) {
                    return false; 
                }
            }
        }
        
        return true; 
    }
    
    private boolean checkRow(char[][] board, int i) {
        char[] row = board[i]; 
        boolean[] seen = new boolean[9];
        
        for (char c : row) {
            if (c != '.') {
                int index = c - '1'; 
                
                if (seen[index]) {
                    return false; 
                }
                
                seen[index] = true; 
            }
        }
        
        return true; 
    }
    
    private boolean checkCol(char[][] board, int j) {
        boolean[] seen = new boolean[9]; 
        
        for (int i = 0; i < 9; i++) {
            char c = board[i][j]; 
            
            if (c != '.') {
                int index = c - '1'; 
                
                if (seen[index]) {
                    return false; 
                }
                
                seen[index] = true; 
            }
        }
        
        return true; 
    }
    
    private boolean checkQuad(char[][] board, int a, int b) {
        boolean[] seen = new boolean[9]; 
        
        for (int i = 3 * a; i < 3 * a + 3; i++) {
            for (int j = 3 * b; j < 3 * b + 3; j++) {
                char c = board[i][j]; 
                
                if (c != '.') {
                    int index = c - '1'; 
                    
                    if (seen[index]) {
                        return false; 
                    }
                    
                    seen[index] = true; 
                }
            }
        }
        
        return true; 
    }
}
