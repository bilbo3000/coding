public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, 0, p, 0); 
    }
    
    private boolean helper(String s, int i, String p, int j) {
        int len1 = s.length(); 
        int len2 = p.length(); 
        
        if (len1 == i) {
            if (j == len2) {
                return true; 
            }
            
            if (j < len2 - 1 && p.charAt(j + 1) == '*') {
                return helper(s, i, p, j + 2); 
            }
            
            return false; 
        }
        
        if (j == len2 && i != len1) {
            return false; 
        }
        
        if (j < len2 - 1 && p.charAt(j + 1) == '*') {
            boolean result = helper(s, i, p, j + 2);
            
            if (!result && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                result = helper(s, i + 1, p, j); 
            }
            
            return result; 
        } else {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                return helper(s, i + 1, p, j + 1); 
            }
            
            return false; 
        }
    }
}
