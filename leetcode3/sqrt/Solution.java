public class Solution {
    public int sqrt(int x) {
        if (x == 0) {
            return 0; 
        }
        
        if (x < 4) {
        	return 1; 
        }
        
        long n = 2; 
        
        while (n * n < x) {
            n = n * 2; 
        }
              
        long left = n / 2; 
        long right = n; 
        
        while (left <= right) {
            long mid = (left + right) / 2; 
            
            if (mid * mid == x) {
                return (int) mid; 
            }
            else if (mid * mid > x) {
                right = mid - 1; 
            }
            else {
                left = mid + 1; 
            }
        }
        
        return (int)right; 
    }
}
