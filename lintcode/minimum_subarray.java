public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     * Dynamic programming. Optimal substructure. 
     * O(n).
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size(); 
        int[] arr = new int[len]; 
        arr[0] = nums.get(0); 
        int min = arr[0]; 
        
        for (int i = 1; i < len; i++) {
            arr[i] = Math.min(nums.get(i), nums.get(i) + arr[i - 1]);
            if (arr[i] < min) {
                min = arr[i]; 
            }
        }
        
        return min; 
    }
}

