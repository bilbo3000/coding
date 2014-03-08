public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length; 
        
        if (m == 0) {
            return false; 
        }
        
        int n = board[0].length; 
        
        if (n == 0) {
            return false; 
        }
        
        // Check rows 
        for (int i = 0; i < m; i++) {
            int check = 0; 
            
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue; 
                }
                
                int digit = board[i][j] - '0'; 
                
                if (digit > 9 || ((1 << digit) & check) != 0) {
                    return false; 
                }
                
                check |= (1 << digit); 
            }
        }
        
        // Check columns 
        for (int j = 0; j < n; j++) {
            int check = 0; 
            
            for (int i = 0; i < m; i++) {
                if (board[i][j] == '.') {
                    continue; 
                }
                
                int digit = board[i][j] - '0'; 
                
                if (digit > 9 || ((1 << digit) & check) != 0) {
                    return false; 
                }
                
                check |= (1 << digit); 
            }
        }
        
        // Check quadrant 
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                int check = 0; 
                
                for (int i = a * 3; i < a * 3 + 3; i++) {
                    for (int j = b * 3; j < b * 3 + 3; j++) {
                        if (board[i][j] == '.') {
                            continue; 
                        }
                        
                        int digit = board[i][j] - '0'; 
                        
                        if (digit > 9 || ((1 << digit) & check) != 0) {
                            return false; 
                        }
                        
                        check |= (1 << digit); 
                    }
                }
            }
        }
        
        return true; 
    }
}
