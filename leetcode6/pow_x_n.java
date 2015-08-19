/**
 * Calcualte double pow(double, int). 
 * The core is that: 
 * num1 = pow(x, n / 2); 
 * num2 = pow(x, n % 2);
 * result = num1 * num1 * num2 
 * where each time it cuts the calculation in half. 
 */ 
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return (double) 1;
        }
        
        long m = (long)n; 
        boolean isNeg = false; 
        
        if (m < 0) {
            isNeg = true; 
            m = -m; 
        }
        
        double result = helper(x, m);
        
        if (isNeg) {
            result = 1 / result; 
        }
        
        return result;
    }
    
    private double helper(double x, long n) {
        if (n == 0) {
            return (double) 1; 
        }
        
        if (n == 1) {
            return x; 
        }
        
        double temp1 = helper(x, n / 2);
        double temp2 = helper(x, n % 2);
        
        return temp1 * temp1 * temp2; 
    }
}
