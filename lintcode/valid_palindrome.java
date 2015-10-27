public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return true; 
        }
        
        int i = 0; 
        int j = len - 1; 
        
        while (i <= j) {
            while (i <= j && !Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i++; 
            }
            
            while (i <= j && !Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j--; 
            }
            
            if (i <= j) {
                if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++; 
                j--;
                    
                } else {
                    return false; 
                }
            }
            
        }
        
        return true; 
    }
}
