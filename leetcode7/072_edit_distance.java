/*
Edit distance. The mininum number of edits to convert word1 to word2. 

Dynamic programming. 
t[i][j]: the edit distance convert word1[:i - 1] to word2[:j - 1]

if word1[i - 1] == word2[j - 1] --> t[i][j] = t[i - 1][j - 1] (last char equal, edit distance equal to previous part)
else choose the min of the three blow: 
1) Insert: t[i][j - 1] + 1; 
2) Delete: t[i - 1][j] + 1; 
3) Replace: t[i - 1][j - 1] + 1; 
*/ 
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(); 
        int n = word2.length();
        int[][] t = new int[m + 1][n + 1]; 
        
        // Initialize first row
        for (int j = 1; j < n + 1; j++) {
            t[0][j] = j; 
        }
        
        // Initialize first column
        for (int i = 1; i < m + 1; i++) {
            t[i][0] = i; 
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1]; 
                } else {
                    // Inert 
                    int temp = t[i][j - 1] + 1; 
                    
                    // Delete
                    temp = Math.min(temp, t[i - 1][j] + 1);
                    
                    // Replace
                    temp = Math.min(temp, t[i - 1][j - 1] + 1);
                    t[i][j] = temp;
                }
            }
        }
        
        return t[m][n];
    }
}
