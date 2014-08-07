public class Solution {
    public boolean isPalindrome(int x) {
        long n = x; 
        if (n < 0) {
            return false; 
        }
        
        long base = 1; 
        
        while(n / base > 9) {
            base = base * 10; 
        }
        
        while(n > 0) {
            long left = n / base; 
            long right = n % 10; 
            
            if (left != right) {
                return false; 
            }
            
            n = n % base / 10; 
            base = base / 100; 
        }
        
        return true; 
    }
}
