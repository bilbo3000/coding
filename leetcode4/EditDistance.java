public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(); 
        int n = word2.length(); 
        
        int[][] T = new int[m + 1][n + 1];
        T[0][0] = 0; 
        
        for (int i = 1; i < m + 1; i++) {
            T[i][0] = i; 
        }
        
        for (int j = 1; j < n + 1; j++) {
            T[0][j] = j; 
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1]; 
                } else {
                    T[i][j] = T[i][j - 1] + 1; // add 
                    T[i][j] = Math.min(T[i][j], T[i - 1][j] + 1);  // delete
                    T[i][j] = Math.min(T[i][j], T[i - 1][j - 1] + 1);  // update 
                }
            }
        }
        
        return T[m][n]; 
    }
}
