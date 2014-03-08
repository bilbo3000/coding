public class Solution {
    public int reverse(int x) {
        boolean isNeg = false; 
        
        if (x < 0) {
            isNeg = true; 
            x = Math.abs(x); 
        }
        
        String s = Integer.toString(x);
        char[] c = s.toCharArray(); 
        int len = c.length; 
        
        int i = 0; 
        int j = len - 1; 
        
        while (i < j) {
            char temp = c[i]; 
            c[i] = c[j]; 
            c[j] = temp; 
            i++; 
            j--; 
        }
        
        s = new String(c);
        long result = Long.parseLong(s);
        
        if (result > Integer.MAX_VALUE) {
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
        }
        
        return isNeg ? -1 * (int)result : (int)result; 
    }
}
