public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0; 
        int r = s.length() - 1; 
        
        while (l <= r) {
            while (l <= r && !Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
                l++; 
            }
            
            while (l <= r && !Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))) {
                r--; 
            }
            
            if (l > r) {
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
