public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     * Dynamic programming.
     * T[i][j]: the minimum number of steps to convert first i letters in word1 
     * to first j letters in word2. 
     * O(mn)
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(); 
        int len2 = word2.length(); 
        
        if (len1 == 0) {
            return len2; 
        }
        
        if (len2 == 0) {
            return len1; 
        }
        
        char[] arr1 = word1.toCharArray(); 
        char[] arr2 = word2.toCharArray();
        int[][] T = new int[len1 + 1][len2 + 1]; 
        T[0][0] = 0;
        
        for (int i = 1; i <= len1; i++) {
            T[i][0] = i; 
        }
        
        for (int j = 1; j <= len2; j++) {
            T[0][j] = j; 
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    T[i][j] = T[i - 1][j - 1]; 
                } else {
                    T[i][j] = T[i - 1][j - 1] + 1; 
                    T[i][j] = Math.min(T[i][j], T[i - 1][j] + 1);
                    T[i][j] = Math.min(T[i][j], T[i][j - 1] + 1);
                }
            }
        }
        
        return T[len1][len2]; 
    }
}
