public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     * 
     * num & (num - 1) will reset the right most 1 each time. We just 
     * need to count how many times it resets ones. 
     */
    public int countOnes(int num) {
        // write your code here
        int cnt = 0; 
        
        while (num != 0) {
            cnt++; 
            num = num & (num - 1);
        }
        
        return cnt; 
    }
};
