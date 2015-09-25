class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     *
     * Full adder: 
     * s = a ^ b ^ c; 
     * c = (a & b) | (a & c) | (b & c);
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int c = 0; 
        int s = 0; 
        
        for (int i = 0; i < 32; i++) {
            int l = a & 1; 
            int r = b & 1; 
            int d = l ^ r ^ c; 
            c = (l & r) | (l & c) | (r & c); 
            s = s | (d << i); 
            a = a >>> 1; 
            b = b >>> 1; 
        }
        
        return s; 
    }
};
