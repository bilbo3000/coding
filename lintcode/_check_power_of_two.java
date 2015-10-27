class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     * n ^ (n - 1) will set all bits include the last one to 1, which makes 
     * it 2n - 1 if n is power of two. 
     */
    public boolean checkPowerOf2(int n) {
        if (n <= 0) return false; 
        return (n ^ (n - 1)) == (n * 2 - 1); 
    }
};
