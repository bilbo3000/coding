class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     * 
     * KMP algorithm. 
     * O(n).
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1; 
        }
        
        int len1 = source.length(); 
        int len2 = target.length(); 
        
        if (len2 == 0) {
            return 0; 
        }
        
        if (len1 < len2) {
            return -1; 
        }
        
        int[] p = pi(target); 
        int m = 0; 
        int i = 0; 
        
        while (i < source.length()) {
            while (m != 0 && source.charAt(i) != target.charAt(m)) {
                m = p[m - 1]; 
            }
            
            if (source.charAt(i) == target.charAt(m)) {
                m++; 
            }
            
            if (m == target.length()) {
                return i - m + 1; 
            }
            
            i++; 
        }
        
        return -1; 
    }
    
    private int[] pi(String target) {
        int len = target.length(); 
        int[] p = new int[len]; 
        int k = 0; 
        
        for (int i = 1; i < len; i++) {
            while (k != 0 && target.charAt(k) != target.charAt(i)) {
                k = p[k - 1]; 
            }
            
            if (k == 0) {
                p[i] = 0; 
            } else {
                p[i] = k + 1; 
            }
        }
        
        return p; 
    }
}
