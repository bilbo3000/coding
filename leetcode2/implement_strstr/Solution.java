public class Solution {
    public String strStr(String haystack, String needle) {
        int n = haystack.length(); 
        int m = needle.length();
        
        if (m == 0) return haystack; 
        
        int[] pi = computePrefix(needle); 
        int q = 0; // Length of match so far 
        
        for (int i = 0; i < n; i++) {
            while (q > 0 && needle.charAt(q) != haystack.charAt(i)) {
                q = pi[q - 1]; 
            }
            
            if (needle.charAt(q) == haystack.charAt(i)) {
                q = q + 1; 
            }
            
            if (q == m) return haystack.substring(i + 1 - m); 
        }
        
        return null; 
    }
    
    private int [] computePrefix(String needle) {
        int len = needle.length(); 
        int [] pi = new int [len]; 
        
        if (len == 0) return pi; 
        
        pi[0] = 0; 
        int k = pi[0];  // Length of longest prefix 
        
        for (int i = 1; i < len; i++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(i)) {
                k = pi[k - 1]; 
            }
            
            if (needle.charAt(k) == needle.charAt(i)) {
                k = k + 1; 
            }
            
            pi[i] = k; 
        }
        
        return pi; 
    }
}
