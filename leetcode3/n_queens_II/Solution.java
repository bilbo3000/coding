public class Solution {
    private int cnt = 0; 
    
    public int totalNQueens(int n) {
        helper(new int[n], 0, n); 
        
        return cnt; 
    }
    
    private void helper(int[] rowcol, int row, int n)  {
        if (row == n) {
            cnt++;
            return; 
        }
        
        for (int col = 0; col < n; col++) {
            if (check(rowcol, row, col)) {
                int[] tempRowcol = rowcol.clone(); 
                tempRowcol[row] = col; 
                helper(tempRowcol, row + 1, n); 
            }
        }
    }
    
    private boolean check(int[] rowcol, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (rowcol[i] == col) {
                return false; 
            }
            
            if (Math.abs(row - i) == Math.abs(col - rowcol[i])) {
                return false; 
            }
        }
        
        return true; 
    }
}
