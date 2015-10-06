public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     * 
     * Similar idea as Remove duplicates I. Maintain a pointer points to the last
     * element that satisfy the condition. Compare the current element with the 
     * element pointed by the pointer and the one before the last one. 
     * 
     * O(n)
     */
    public int removeDuplicates(int[] nums) {
        int last = -1; 
        
        for (int i = 0; i < nums.length; i++) {
            if (last == -1 || last == 0) {
                last++; 
            } else {
                if (nums[i] != nums[last] || nums[i] != nums[last - 1]) {
                    last++; 
                    nums[last] = nums[i]; 
                }
            }
        }
        
        return last + 1;
    }
}
