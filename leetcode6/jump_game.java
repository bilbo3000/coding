/**
 * For a list of max steps, determine whether we can jump from the start to the end. 
 * The idea was to maintian a boolean array meaning whether we can get to a given position. 
 * Initialize true in the array with all the positions we can reach with one jump to save 
 * some computation. For the rest indexs, check every previous reachable position and see 
 * if the current index can be reached from there. 
 */ 
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return false; 
        }
        
        boolean[] flag = new boolean[len]; 
        int i = 0; 
        
        while (i < len && i <= nums[0]) {
            flag[i] = true; 
            i++; 
        }
        
        while (i < len) {
            int j = i - 1; 
            
            while (j >= 0) {
                if (flag[j] && nums[j] >= (i - j)) {
                    flag[i] = true; 
                    break; 
                }
                
                j--; 
            }
            
            i++; 
        }
        
        return flag[len - 1]; 
    }
}
