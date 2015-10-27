public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     * 
     * At most there will be two candidates that satisfy the condition. 
     * After finding the candidates, we must go through the list and count 
     * each one and return the one with larger count. 
     * 
     * O(n). 
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int a = 0; 
        int b = 0; 
        int c1 = 0; 
        int c2 = 0; 
        
        for (int n : nums) {
            if (n == a) {
                c1++; 
            } else if (n == b) {
                c2++; 
            } else {
                if (c1 == 0) {
                    a = n; 
                    c1++; 
                } else if (c2 == 0) {
                    b = n; 
                    c2++; 
                } else {
                    c1--; 
                    c2--; 
                }
            }
        }
        
        c1 = 0; 
        c2 = 0; 
        
        for (int n : nums) {
            if (n == a) {
                c1++; 
            } else if (n == b) {
                c2++; 
            }
        }
        
        if (c1 >= c2) {
            return a; 
        } else {
            return b; 
        }
    }
}

