public class Solution {
    public int numDistinct(String S, String T) {
        int len1 = S.length(); 
        int len2 = T.length(); 
        
        if (len1 == 0 || len2 == 0) {
            return 0; 
        }
        
        int[][] table = new int[len2][len1]; 
        
        table[0][0] = S.charAt(0) == T.charAt(0)? 1 : 0; 
        
        for (int j = 1; j < len1; j++) {
            table[0][j] = T.charAt(0) == S.charAt(j) ? table[0][j - 1] + 1 : table[0][j - 1]; 
        }
        
        for (int i = 1; i < len2; i++) {
            for (int j = 1; j < len1; j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    table[i][j] = table[i - 1][j - 1] + table[i][j - 1]; 
                } else {
                    table[i][j] = table[i][j - 1]; 
                }
            }
        }
        
        return table[len2 - 1][len1 - 1]; 
    }
}
