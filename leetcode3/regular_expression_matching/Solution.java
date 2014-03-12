import java.util.*;
public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int i, String p, int j) {  
        int slen = s.length(); 
        int plen = p.length(); 
        
        if (i == slen && j == plen) {
            return true;
        }

        if (i != slen && j == plen) {
            return false;
        }

        if (i == slen) {
            if (j == plen - 1) {
                return false; 
            }
            
            if (j < plen - 1 && p.charAt(j + 1) != '*') {
                return false; 
            }
        }

        if (j + 1 < plen && p.charAt(j + 1) == '*') {
            boolean result = helper(s, i, p, j + 2);
            
            if (!result && i < slen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                result = helper(s, i + 1, p, j); 
            }
            
            return result; 
        }
        else {
            if (i < slen && j < plen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return helper(s, i + 1, p, j + 1); 
            }
            
            return false; 
        }
    }
}
