/**
 * Find a 3sum that adds up cloest to the given target. 
 * First sort the array. Then for each first element, use two pointers to 
 * navigate the second and third element. Meanwhile, maintain the diff and 
 * current most optimal result. 
 */ 
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0; 
        int diff = Integer.MAX_VALUE; 
        int len = nums.length; 
        
        for (int a = 0; a < len - 2; a++) {
            int b = a + 1; 
            int c = len - 1;
            
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c]; 
            
                if (Math.abs(sum - target) < diff) {
                    result = sum; 
                    diff = Math.abs(sum - target);
                }
                
                if (target == sum) {
                    return result; 
                } else if (sum < target) {
                    b++; 
                } else {
                    c--; 
                }
            }
        }
        
        return result; 
    }
}
