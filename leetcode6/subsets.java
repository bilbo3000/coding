/**
 * Find all subsets for an array of distinct integers. 
 * The idea was first sort the array. Then loop through each element 
 * in the array and append that element to each item in the result. 
 * Add that new element to the end of result. 
 */ 
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        result.add(new ArrayList<Integer>());
        int len = nums.length; 
        
        if (len == 0) {
            return result; 
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < len; i++) {
            int n = result.size(); 
            
            for (int j = n - 1; j >= 0; j--) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        
        return result; 
    }
}
