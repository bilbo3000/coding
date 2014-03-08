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
        
        double divResult = pow(x, n / 2); 
        double modResult = pow(x, n % 2);
        
        double result = divResult * divResult * modResult; 
        
        return isNeg ? 1 / result : result; 
    }
}
