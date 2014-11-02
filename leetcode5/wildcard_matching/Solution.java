public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(); 
        int len2 = p.length(); 
        int i = 0; 
        int j = 0; 
        int lasti = -1; 
        int lastj = -1; 
        
        while (i < len1) {
            if (j == len2) {
                if (lasti == -1 || lastj == -1) {
                    return false; 
                } else {
                    i = lasti + 1; 
                    j = lastj; 
                }
            } else {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    i++; 
                    j++; 
                } else if (p.charAt(j) == '*') {
                    lasti = i; 
                    lastj = j; 
                    j++; 
                } else {
                    if (lasti == -1 || lastj == -1) {
                        return false; 
                    } else {
                        i = lasti + 1; 
                        j = lastj; 
                    } 
                }
            }
        }
        
        while (j < len2 && p.charAt(j) == '*') {
            j++; 
        }
        
        if (j == len2) {
            return true; 
        }
        
        return false; 
    }
}
