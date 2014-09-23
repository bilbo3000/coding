public class Solution {
    public int reverse(int x) {
        boolean isNeg = false; 
        
        if (x < 0) {
            isNeg = true; 
            x = -x; 
        }
        
        int result = 0; 
        
        while (x > 0) {
            int digit = x % 10; 
            x = x / 10; 
            result = result * 10 + digit; 
        }
        
        return isNeg ? result * -1 : result; 
    }
}
