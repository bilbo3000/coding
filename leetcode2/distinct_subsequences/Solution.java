public class Solution {
    public int numDistinct(String S, String T) {
        int n = S.length(); 
        int m = T.length(); 
        int [][] table = new int[m + 1][n + 1]; 
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                table[i][j] = 0; 
            }
        }
        
        // Initialize first row 
        for (int j = 1; j <= n; j++) {
            if (T.charAt(0) == S.charAt(j - 1)) {
                table[1][j] = table[1][j - 1] + 1; 
            }
            else {
                table[1][j] = table[1][j - 1]; 
            }
        }
        
        // No need to initialize first column 
        
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + table[i][j - 1]; 
                }
                else {
                    table[i][j] = table[i][j - 1]; 
                }
            }
        }
        
        return table[m][n]; 
    }
}
