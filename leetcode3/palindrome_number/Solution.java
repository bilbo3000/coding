public class Solution {
    public boolean isPalindrome(int input) {
        boolean isNeg = false; 
        long x = input; 
        
        if (x < 0) {
            return false; 
        }
        
        long divisor = 1; 
        
        while (x / divisor > 9) {
            divisor *= 10; 
        }
        
        while (x > 0) {
            long left = x / divisor; 
            long right = x % 10; 
            
            if (left != right) {
                return false; 
            }
            
            x = (x % divisor) / 10; 
            divisor /= 100; 
        }
        
        return true; 
    }
}
