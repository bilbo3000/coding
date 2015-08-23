public class Solution {
    public int nthUglyNumber(int n) {
        int count = 0; 
        int num = 0; 
        
        while (count < n) {
            num++; 
            
            if (isUgly(num)) {
                count++;
            }
        }
        
        return num; 
    }
    
    private boolean isUgly(int n) {
        if (n <= 0) {
            return false; 
        }
        
        if (n == 1) {
            return true; 
        }
        
        n = helper(n, 2);
        n = helper(n, 3); 
        n = helper(n, 5); 
        
        if (n == 1) {
            return true; 
        }
        
        return false; 
    }
    
    private int helper(int n, int factor) {
        while (n % factor == 0) {
            n /= factor; 
        }
        
        return n; 
    }
}
