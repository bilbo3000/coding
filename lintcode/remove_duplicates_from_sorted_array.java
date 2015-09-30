public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     * 
     * O(n^2)
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length; 
        
        for (int i = 0; i < len; i++) {
            if (i + 1 < len && nums[i] == nums[i + 1]) {
                int j = i + 1; 
                
                while (j < len) {
                    nums[j - 1] = nums[j]; 
                    j++; 
                }
                
                len--; 
                i--; 
            }
        }
        
        return len;
    }
}
