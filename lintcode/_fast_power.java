class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     * O(logn)
     */
    public int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b; 
        }
        
        if (n == 1) {
            return a % b; 
        }
        
        long temp1 = fastPower(a, b, n / 2);
        
        long product = (temp1 * temp1) % b; 
        
        if (n % 2 != 0) {
            product = (product * a) % b;
        }
        
        return (int) product; 
    }
};
