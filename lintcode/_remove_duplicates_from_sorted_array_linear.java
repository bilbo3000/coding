public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     * 
     * Take advantage of the fact that the array is sorted. Thus we can maintain
     * an index that always points to last element in the current array only 
     * contains unique elements. Then we can walk through the array and whenever
     * there is an element that is different from the element pointed by index, 
     * we move over this element and update index. 
     * 
     * O(n)
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int last = 0; 
        
        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[last]) {
                last++; 
                nums[last] = nums[i]; 
            }
        }
        
        return last + 1; 
    }
}
