/*
Decide whether the regex can match the string. 

Regex --> 1) recursive; 2) divided into cases; 

Cases: 
1) regex is empty; --> return true (done with matching, need to check whether exhaust the string); 
2) regex is a star match; --> Try to match one char at a time and the nth suffix matching the remaining regex; 
--> If all failed, try not match; 
3) regex is an alphanumerical match; --> match and continue with the rest of regex and string; 
*/
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false; 
        }
        
        if (s.length() != 0 && p.length() == 0) {
            return false; 
        }
        
        // Case 1
        if (s.length() == 0 && p.length() == 0) {
            return true; 
        }
        
        // Case 2
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // Try to recursively match char one at a time
            // ONLY IF CONDITION HOLDS
            int i = 0; 
            
            while (i < s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                
                i++; 
            }
            
            // Try not to match
            return isMatch(s, p.substring(2));
        }
        
        // Case 3
        if (s.length() != 0) {
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false; 
            }
        }
            
        // All other cases return false
        return false; 
    }
}
