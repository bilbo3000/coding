public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     * 
     * 1. Find split point. 
     * 2. Swap first and second segment individually, which leads the whole 
     * array in reverse order. 
     * 3. Reverse the whole array. 
     * 
     * O(n) time, in place. 
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int len = nums.size(); 
        
        int i = 1; 
        
        while (i < len) {
            if (nums.get(i) >= nums.get(i - 1)) {
                i++; 
            } else {
                break; 
            }
        }
        
        if (i == len) {
            // No rotation 
            return; 
        }
        
        int a = 0; 
        int b = i - 1; 
        int j = len - 1; 
        
        while (a < b) {
            swap(nums, a, b);
            a++; 
            b--; 
        }
        
        while (i < j) {
            swap(nums, i, j);
            i++; 
            j--; 
        }
        
        i = 0; 
        j = len - 1; 
        
        while (i < j) {
            swap(nums, i, j);
            i++; 
            j--; 
        }
    }
    
    private void swap(ArrayList<Integer> nums, int i, int j) {
       int temp = nums.get(i);
       nums.set(i, nums.get(j));
       nums.set(j, temp);
    }
}
