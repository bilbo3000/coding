public class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length(); 
        int l = 0; 
        int r = len - 1; 
        
        while (l < r) {
            while (l < len && !('a' <= s.charAt(l) && s.charAt(l) <= 'z' || 'A' <= s.charAt(l) && s.charAt(l) <= 'Z' || '0' <= s.charAt(l) && s.charAt(l) <= '9')) {
                l++; 
            }
            
            while (r >= 0 && !('a' <= s.charAt(r) && s.charAt(r) <= 'z' || 'A' <= s.charAt(r) && s.charAt(r) <= 'Z' || '0' <= s.charAt(r) && s.charAt(r) <= '9')) {
                r--; 
            }
            
            if (l >= r) {
                return true; 
            }
            
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false; 
            }
            
            l++; 
            r--; 
        }
        
        return true; 
    }
}
