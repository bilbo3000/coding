/**
 * KMP algorithm. 
 * pi[i] tracks the length of the longest prefix as proper sufix for substring ending at index i. 
 */ 
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0; 
        }
        
        if (haystack.length() == 0) {
            return -1; 
        }
        
        if (needle.length() == 0) {
            return 0; 
        }
        
        int[] pi = pi(needle);
        int len = haystack.length(); 
        int m = 0; 
        int i = 0; 
        
        while (i < len) {
            while (m > 0 && needle.charAt(m) != haystack.charAt(i)){
                m = pi[m - 1]; 
            }
            
            if (needle.charAt(m) == haystack.charAt(i)) {
                m++; 
            }
            
            if (m == needle.length()) {
                break; 
            }
            
            i++; 
        }
        
        if (m == needle.length()) {
            return i - m + 1; 
        }
        
        return -1; 
    }
    
    private int[] pi(String needle) {
        int len = needle.length(); 
        int[] pi = new int[len]; 
        
        if (len == 0) {
            return pi; 
        }
        
        pi[0] = 0; 
        int k = 0; 
        
        for (int i = 1; i < len; i++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(i)) {
                k = pi[k - 1]; 
            }
            
            if (needle.charAt(k) == needle.charAt(i)) {
                k++; 
            }
            
            pi[i] = k; 
        }
        
        return pi; 
    }
}
