public class Solution {
    /**
     * @param s a string
     * @return an integer
     * 
     * Dynamic programming. 
     * O(n^2)
     */
    public int minCut(String s) {
        int len = s.length(); 
        boolean[][] p = isPalin(s); 
        int[] T = new int[len];  // T[i]: min cut for s[..i]
        
        for (int i = 1; i < len; i++) {
            if (p[0][i]) {
                continue; 
            }
            
            int j = i - 1; 
            T[i] = Integer.MAX_VALUE;
            
            while (j >= 0) {
                if (p[j + 1][i]) {
                    T[i] = Math.min(T[i], T[j] + 1);
                }
                
                j--; 
            }
        } 
        
        return T[len - 1]; 
    }
    
    private boolean[][] isPalin(String s) {
        int len = s.length(); 
        char[] arr = s.toCharArray(); 
        boolean[][] T = new boolean[len][len]; 
        
        for (int i = 0; i < len; i++) {
            T[i][i] = true; 
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                T[i][i + 1] = true; 
            }
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (arr[i] == arr[j]) {
                    T[i][j] = T[i + 1][j - 1]; 
                }
            }
        }
        
        return T; 
    }
};
