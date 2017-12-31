/**
 * Given a wrap around array nums, for each element, find the next 
 * greater element. 
 * 
 * For each element in the array, search next elements at indexes 
 * (j + 1) % length;
 * 
 * Time: O(n^2)
 * Space: O(1)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length; 
        int[] res = new int[n];
        int i = 0; 
        
        while (i < n) {
            res[i] = -1; 
            
            int j = (i + 1) % n;
            
            while (j != i) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break; 
                }
                
                j = (j + 1) % n;
            }
            i++; 
        }
        
        return res;
    }
}
