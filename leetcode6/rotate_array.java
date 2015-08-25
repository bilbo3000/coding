public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length; 
        k = k % len; 
        if (k == 0) return; 
        int[] temp = new int[k]; 
        int x = 0; 
        
        for (int i = len - k; i < len; i++) {
            temp[x] = nums[i]; 
            x++; 
        }
        
        for (int i = len - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i]; 
        }
        
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i]; 
        }
    }
}
