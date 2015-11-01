class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     * 
     * O(log(x)) time. 
     */
    public int sqrt(int x) {
        long l = (long) x; 
        long r = 0; 
        
        while (l >= r) {
            long mid = (l + r) / 2; 
            long val = mid * mid; 
            long nextVal = (mid + 1) * (mid + 1);
            
            if (val <= (long) x && nextVal > (long) x) {
                return (int) mid; 
            }
            
            if (val > (long) x) {
                l = mid - 1; 
            } else {
                r = mid + 1;
            }
        }
        
        return x; 
    }
}
