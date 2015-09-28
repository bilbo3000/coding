public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     * Similar to sort color. Index points to last odd number. 
     * O(n). 
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int len = nums.length; 
        int index = -1; 
        
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 != 0) {
                index++; 
                int temp = nums[i]; 
                nums[i] = nums[index]; 
                nums[index] = temp; 
            }
        }
    }
}
