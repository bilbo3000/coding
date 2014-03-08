public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // T[i][j]: edit distance to convert first ith word1 letters to first jth word2 letters
        int[][] T = new int[len1 + 1][len2 + 1];

        // Initialization first row
        for (int j = 0; j <= len2; j++) {
            T[0][j] = j;
        }

        // Initialization first column
        for (int i = 0; i <= len1; i++) {
            T[i][0] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1];
                }
                else {
                    T[i][j] = T[i - 1][j - 1] + 1;  // Replace
                    T[i][j] = Math.min(T[i][j], T[i - 1][j] + 1);  // Delete
                    T[i][j] = Math.min(T[i][j], T[i][j - 1] + 1);  // Insert
                }
            }
        }

        return T[len1][len2];
    }
}
