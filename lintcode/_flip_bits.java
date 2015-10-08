class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     * 
     * bit manipulation. 
     */
    public static int bitSwapRequired(int a, int b) {
        int xor = a ^ b; 
        int count = 0; 
        
        while (xor != 0) {
            xor &= (xor - 1); 
            count++; 
        }
        
        return count; 
    }
};

