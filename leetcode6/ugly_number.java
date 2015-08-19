public class Solution {
    public boolean isUgly(int num) {
        long x = (long) num; 
        
        if (x < 0) {
            return false; 
        }
        
        if (x == 0) {
            return false; 
        }
        
        if (x == 1) {
            return true; 
        }
        
        

        while (x > 1) {
            if (x % 2 == 0) {
                x = x / 2; 
                continue; 
            } else if (x % 3 == 0) {
                x = x / 3; 
                continue; 
            } else if (x % 5 == 0) {
                x = x / 5; 
                continue; 
            }
            
            return false; 
        }
        
        return true; 
    }
}
