public class Solution {
    private int counter = 0; 
    
    public int totalNQueens(int n) {
        int[] rowcol = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            rowcol[i] = -1; 
        }
        
        helper(0, rowcol, n); 
        
        return counter; 
    }
    
    private void helper(int row, int[] rowcol, int n) {
        if (row == n) {
            counter++; 
        } else {
            for (int j = 0; j < n; j++) {
                boolean flag = check(row, j, rowcol); 
                
                if (flag) {
                    rowcol[row] = j; 
                    helper(row + 1, rowcol, n); 
                    rowcol[row] = -1; 
                }
            }
        }
    }
    
    private boolean check(int i, int j, int[] rowcol) {
        for (int x = i - 1; x >= 0; x--) {
            if (j == rowcol[x]) {
                return false; 
            }
            
            if (i - x == Math.abs(rowcol[x] - j)) {
                return false; 
            }
        }
        
        return true; 
    }
}
