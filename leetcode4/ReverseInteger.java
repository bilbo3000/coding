public class Solution {
    public int reverse(int x) {
        boolean isNeg = false; 
        int result = 0; 
        
        if (x < 0) {
            isNeg = true; 
            x = -x; 
        }
        
        while (x > 0) {
            int digit = x % 10; 
            x = x / 10; 
            result = result * 10 + digit; 
        }
        
        if (isNeg) {
            return -result; 
        }
        
        return result; 
    }
}
