/**
 * Find all unique 4sums that sum up to the given target. 
 * The idea was that for each leading element, run three sum on the remaining value. 
 * Then insert the current element at the beginning of each return list from 3sum. 
 * Use a HashSet to keep track of the history to eliminate duplicates. 
 */ 
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length; 
        Set<List<Integer>> history = new HashSet<List<Integer>>(); 
        
        for (int i = 0; i < len - 3; i++) {
            Set<List<Integer>> temp = threeSum(nums, i + 1, len - 1, target - nums[i]); 
            
            for (List<Integer> item : temp) {
                item.add(0, nums[i]); 
                history.add(item);
            }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        for (List<Integer> item : history) {
            result.add(item);
        }
        
        return result; 
    }
    
    public Set<List<Integer>> threeSum(int[] nums, int l, int r, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        
        for (int a = l; a <= r - 2; a++) {
            int b = a + 1; 
            int c = r; 
            
            while (b < c) {
            	int sum = nums[a] + nums[b] + nums[c]; 
            	
                if (sum == target){
                    List<Integer> temp = new ArrayList<>(); 
                    temp.add(nums[a]);
                    temp.add(nums[b]);
                    temp.add(nums[c]);
                    result.add(temp);
                    b++; 
                    c--; 
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
