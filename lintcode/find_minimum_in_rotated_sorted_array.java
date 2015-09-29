public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     * 
     * O(n).
     */
    public int findMin(int[] num) {
        // write your code here
        int len = num.length; 
        
        if (num[0] < num[len - 1]) {
            // No rotation
            return num[0]; 
        }
        
        int result = num[0]; 
        
        for (int i = 1; i < len; i++) {
            if (num[i] < num[i - 1]) {
                return num[i]; 
            }
        }
        
        return result; 
    }
}
