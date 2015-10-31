public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        int len3 = s3.length(); 
        
        if (len1 + len2 != len3) {
            return false; 
        }
        
        boolean[][] T = new boolean[len1 + 1][len2 + 1]; 
        T[0][0] = true; 
        
        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                T[i][0] = T[i - 1][0];
            } else {
                T[i][0] = false; 
            }
        }
        
        for (int j = 1; j <= len2; j++) {
        	if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                T[0][j] = T[0][j - 1]; 
            } else {
                T[0][j] = false; 
            }
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c1 = s1.charAt(i - 1); 
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                
                if (c1 != c3 && c2 != c3) {
                    T[i][j] = false; 
                }
                else {
	                if (c1 == c3) {
	                    T[i][j] |= T[i - 1][j]; 
	                }
	                
	                if (c2 == c3) {
	                    T[i][j] |= T[i][j - 1]; 
	                }
                }
            }
        }
        
        return T[len1][len2]; 
    }
}
