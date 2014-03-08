public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(); 
        int len2 = word2.length(); 
        int[][] T = new int[len1 + 1][len2 + 1]; 
        
        for (int j = 0; j < len2 + 1; j++) {
            T[0][j] = j; 
        }
        
        for (int i = 0; i < len1 + 1; i++) {
            T[i][0] = i; 
        }
        
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1]; 
                }
                else {
                    int min = T[i - 1][j - 1] + 1; // Replace 
                    min = Math.min(min, T[i][j - 1] + 1);  // add
                    min = Math.min(min, T[i - 1][j] + 1); // delete 
                    T[i][j] = min; 
                }
            }
        }
        
        return T[len1][len2]; 
    }
}
