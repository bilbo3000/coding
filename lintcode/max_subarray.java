public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     * O(n)
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size(); 
        int[] arr = new int[len]; 
        arr[0] = nums.get(0); 
        int max = arr[0]; 
        
        for (int i = 1; i < len; i++) {
            arr[i] = Math.max(nums.get(i), nums.get(i) + arr[i - 1]);
            max = Math.max(max, arr[i]);
        }
        
        return max; 
    }
}
