/*
Three sum problem: find all unique triplets that sum to zero. 

Brute force approach: check all triplets; 
Time: O(n^3); Space: O(1);

Hash table approach: put all numbers into a bash table. For each pair (a, b), 
check whether -(a + b) is in hash table. 
Time: O(n^3); Space: O(n); 

Sorting appraoch (below): 
Sort the input array O(nlogn). For each A[i], use binary search to find pair 
that sum to -A[i] in section A[i + 1: n - 1]; 
Time: O(nlogn) -- sorting; Space: O(1); 

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>(); 
        
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1; 
            int k = nums.length - 1; 
            
            while (j < k ) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> res = new ArrayList<>(); 
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    results.add(res);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++; 
                } else {
                    k--;
                }
            }
        }
        
        return new ArrayList<List<Integer>>(results);
    }
}
