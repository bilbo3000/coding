public class Solution {
    public double pow(double x, int n) {
        boolean isNeg = false; 
        double result = 0.0; 
        long exp = n; 
        
        if (exp < 0) {
            isNeg = true; 
            exp = -exp; 
        }
         
        result = helper(x, exp); 
        
        
        return isNeg ? 1 / result : result; 
    }
    
    public double helper(double x, long exp) {
    	if (exp == 0) return 1.0; 
    	if (exp == 1) return x; 
    	
    	double dividetwo = helper(x, exp / 2); 
    	double modtwo = helper(x, exp % 2); 
    	
    	return dividetwo * dividetwo * modtwo; 
    }
}
