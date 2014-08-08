public class Solution {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0; 
        }
        
        boolean isNeg = false; 
        
        if (n == 1) {
            return x; 
        }
        
        if (n < 0) {
            isNeg = true; 
            n = -n; 
        }
        
        double temp1 = pow(x, n / 2);
        double temp2 = pow(x, n % 2);
        
        if (!isNeg) {
            return temp1 * temp1 * temp2; 
        } else {
            return 1 / (temp1 * temp1 * temp2); 
        }
    }
}
