public class Solution {
    char[][] board; 
    public void solveSudoku(char[][] board) {
        this.board = board; 
        helper(); 
    }
    
    private boolean helper() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    boolean result = false; 
                    
                    for (char c = '1'; c <= '9'; c++) {
                        board[i][j] = c;  
                        
                        if (!checkRow(i) || !checkCol(j) || !checkQuad(i, j)) {
                            continue; 
                        }
                        
                        result = helper(); 
                        if (result) {
                            return true; 
                        }
                    }
                    
                    board[i][j] = '.'; 
                    return false; 
                }
            }
        }
        
        return true; 
    }
    
    private boolean checkRow(int i) {
        boolean[] flag = new boolean[9];
        
        for (int n = 0; n < 9; n++) {
            if (board[i][n] == '.') continue; 
            
            int digit = (int) (board[i][n] - '0'); 
            
            if (flag[digit - 1]) {
                return false; 
            }
            else {
                flag[digit - 1] = true; 
            }
        }
        
        return true; 
    }
    
    private boolean checkCol(int j) {
        boolean[] flag = new boolean[9]; 
        
        for (int n = 0; n < 9; n++) {
            if (board[n][j] == '.') continue; 
            
            int digit = (int) (board[n][j] - '0');
            
            if (flag[digit - 1]) {
                return false; 
            }
            else {
                flag[digit - 1] = true; 
            }
        }
        
        return true; 
    }
    
    private boolean checkQuad(int i, int j) {
        int a = i / 3; 
        int b = j / 3; 
        boolean[] flag = new boolean[9]; 
        
        for (int m = 3 * a; m < 3 * a + 3; m++) {
            for (int n = 3 * b; n < 3 * b + 3; n++) {
                if (board[m][n] == '.') continue; 
                
                int digit = (int) (board[m][n] - '0');
                
                if (flag[digit - 1]) {
                    return false; 
                }
                else {
                    flag[digit - 1] = true; 
                }
            }
        }
        
        return true; 
    }
}
