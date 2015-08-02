/**
 * Find all unique 3sums that add up to zero. 
 * First sort the array. Then for each starting number, use two pointers 
 * to traverse the elements behind it. Store the results in a set whenever 
 * it finds a solution. 
 */ 
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length; 
        Set<List<Integer>> history = new HashSet<List<Integer>>();
        
        for (int a = 0; a < len - 2; a++) {
            int b = a + 1; 
            int c = len - 1; 
            
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<Integer>(); 
                    temp.add(nums[a]);
                    temp.add(nums[b]);
                    temp.add(nums[c]);
                    history.add(temp);
                    b++; 
                    c--; 
                } else if (sum < 0) {
                    b++; 
                } else {
                    c--; 
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (List<Integer> item : history) {
            result.add(item);
        }
        
        return result; 
    }
}
