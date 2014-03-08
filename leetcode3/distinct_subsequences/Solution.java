public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length(); 
        int n = T.length(); 
        
        if (m == 0 || n == 0) {
            return 0; 
        }
        
        int[][] table = new int[m][n]; 
        if (S.charAt(0) == T.charAt(0)) {
            table[0][0] = 1; 
        }
        else {
            table[0][0] = 0; 
        }
        
        for (int i = 1; i < m; i++) {
            if (S.charAt(i) == T.charAt(0)) {
                table[i][0] = table[i - 1][0] + 1; 
            }
            else {
                table[i][0] = table[i - 1][0]; 
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    table[i][j] = table[i - 1][j - 1] + table[i - 1][j]; 
                }
                else {
                    table[i][j] = table[i - 1][j]; 
                }
            } 
        }
        
        return table[m - 1][n - 1]; 
    }
}
