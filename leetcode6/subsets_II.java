/**
 * Find all subsets for a given array which could contain duplicates.
 * The idea was similar to previous problem, except whenever we find 
 * a duplicates, we only need to append this element to the new items 
 * inserted by its previous element. The reason is that all the other items 
 * before has already processed by the previous element. There is no 
 * need to process them again. 
 */ 
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        result.add(new ArrayList<Integer>());
        int len = nums.length; 
        
        if (len == 0) {
            return result; 
        }
        
        Arrays.sort(nums);
        int count = 0; 
        
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // Duplicates, only process count number of items
                int j = result.size() - 1; 

                for (int k = 0; k < count; k++) {
                    List<Integer> temp = new ArrayList<>(result.get(j - k));
                    temp.add(nums[i]);
                    result.add(temp);
                }
                
            } else {
                // process all items
                int j = result.size() - 1; 
                count = 0; 
                
                while (j >= 0) {
                    List<Integer> temp = new ArrayList<>(result.get(j));
                    temp.add(nums[i]);
                    result.add(temp);
                    count++; 
                    j--;
                }
            }
        }
        
        return result; 
    }
}
