public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     * 
     * O(n^2) time and O(n^2) memory.
     */
    public int numDistinct(String S, String T) {
        char[] arr1 = S.toCharArray(); 
        char[] arr2 = T.toCharArray();
        int len1 = arr1.length; 
        int len2 = arr2.length; 
        int[][] t = new int[len1][len2]; 
        
        if (arr1[0] == arr2[0]) {
            t[0][0] = 1; 
        }
        
        for (int i = 1; i < len1; i++) {
            if (arr1[i] == arr2[0]) {
                t[i][0] = t[i - 1][0] + 1;  
            } else {
                t[i][0] = t[i - 1][0]; 
            }
        }
        
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (arr1[i] == arr2[j]) {
                    // Include current pair
                    t[i][j]  = t[i - 1][j - 1]; 
                } 
                
                t[i][j] += t[i - 1][j]; 
            }
        }
        
        return t[len1 - 1][len2 - 1]; 
    }
}
