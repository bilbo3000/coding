public class Solution {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0; 
        }
        
        if (n == 1) {
            return x; 
        }
        
        boolean isNeg = false; 
        
        if (n < 0) {
            isNeg = true; 
            n = -n; 
        }
        
        double temp1 = pow(x, n / 2);
        double temp2 = pow(x, n % 2);
        
        double result = temp1 * temp1 * temp2; 
        
        if (isNeg) {
            result = 1 / result; 
        }
        
        return result; 
    }
}
