public class Solution {
    int cnt = 0; 
    
    public int totalNQueens(int n) {
        int[] rowcol = new int[n];
        
        helper(0, rowcol, n); 
        
        return cnt; 
    }
    
    void helper(int row, int[] rowcol, int n) {
        if (row == n) {
            cnt++; 
            return; 
        }
        
        for (int i = 0; i < n; i++) {
            if (check(row, i, rowcol)) {
                int[] rowcolNext = rowcol.clone(); 
                rowcolNext[row] = i; 
                helper(row + 1, rowcolNext, n); 
            }
        }
    }
    
    boolean check(int row, int col, int[] rowcol) {
        for (int i = row - 1; i >= 0; i--) {
            if (rowcol[i] == col) return false; 
            if (Math.abs(rowcol[i] - col) == Math.abs(i - row)) return false;
        }
        
        return true; 
    }
}
