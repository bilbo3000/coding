public class Solution {
    public int reverse(int x) {
        boolean isNeg = false; 
        
        if (x < 0) {
            isNeg = true; 
        }
        
        long temp = Math.abs(x); 
        String result = "0"; 
        
        while (temp > 0) {
            result += (char)(temp % 10 + '0'); 
            temp /= 10; 
        }
        
        int i = 0; 
        while (i < result.length() && result.charAt(i) == '0') {
            i++; 
        }
        
        if (i != result.length()) {
            result = result.substring(i); 
        }
        
        temp = isNeg ? -Long.parseLong(result) : Long.parseLong(result); 
        
        if (temp > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE; 
        }
        
        if (temp < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; 
        }
        
        return (int) temp; 
    }
}
