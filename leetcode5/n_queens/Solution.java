public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>(); 
        int[] rowcol = new int[n];
        
        for (int i = 0; i < n; i++) {
            rowcol[i] = -1; 
        }
        
        helper(0, rowcol, result, n);
        
        return result; 
    }
    
    private void helper(int row, int[] rowcol, List<String[]> result, int n) {
        if (row == n) {
            // Find a solution 
            String[] sol = new String[n]; 
            
            for (int i = 0; i < n; i++) {
                String str = ""; 
                
                for (int j = 0; j < n; j++) {
                    if (j == rowcol[i]) {
                        str += "Q"; 
                    } else {
                        str += "."; 
                    }
                }
                
                sol[i] = str; 
            }
            
            result.add(sol); 
        } else {
            for (int j = 0; j < n; j++) {
                boolean flag = check(row, j, rowcol);
                
                if (flag) {
                    rowcol[row] = j; 
                    helper(row + 1, rowcol, result, n); 
                    rowcol[row] = -1; 
                }
            }
        }
    }
    
    private boolean check(int i, int j, int[] rowcol) {
        for (int x = i - 1; x >= 0; x--) {
            if (rowcol[x] == j) {
                return false; 
            }
            
            if ((i - x) == Math.abs(rowcol[x] - j)) {
                return false; 
            }
        }
        
        return true; 
    }
}
