public class Solution {
    public int numDistinct(String S, String T) {
        int lenS = S.length(); 
        int lenT = T.length(); 
        
        if (lenS == 0 || lenT == 0) {
            return 0; 
        }
        
        int[][] table = new int[lenT][lenS]; 
        if (S.charAt(0) == T.charAt(0)) {
            table[0][0] = 1; 
        } else {
            table[0][0] = 0; 
        }
        
        for (int j = 1; j < lenS; j++) {
            if (S.charAt(j) == T.charAt(0)) {
                table[0][j] = table[0][j - 1] + 1; 
            } else {
                table[0][j] = table[0][j - 1]; 
            }
        }
        
        for (int i = 1; i < lenT; i++) {
            for (int j = 1; j < lenS; j++) {
                if (T.charAt(i) == S.charAt(j)) { 
                    table[i][j] = table[i - 1][j - 1] + table[i][j - 1]; 
                } else {
                    table[i][j] = table[i][j - 1]; 
                }
            }
        }
        
        return table[lenT - 1][lenS - 1]; 
    }
}
