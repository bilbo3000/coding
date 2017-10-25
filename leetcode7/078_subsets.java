/*
Given a set of distinct integers. Find the powerset. 

Walk through the array. 
Each time create a copy of each item in the current result, 
add current element to it, and insert back to the result. 

The tricky part is to loop the current results backward, 
cause it's size increases during current run. 

Time: O(n^2)
Space: O(2^n)
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int len = nums.length; 
        result.add(new ArrayList<Integer>());
        
        for (int i = 0; i < len; i++) {
            int n = nums[i]; 
            int j = result.size() - 1; 
            
            while (j >= 0) {
                List<Integer> copy = new ArrayList<>(result.get(j));
                copy.add(n);
                result.add(copy);
                j--; 
            }
        }
        
        return result; 
    }
}
