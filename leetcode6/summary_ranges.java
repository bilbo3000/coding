/**
 * Find the summary ranges for the continous elements in the form 
 * of 1->3,5,8->9. 
 * The ideas was to traverse through the input array the maintain 
 * a list of current continous elements. When it keeps find continous 
 * elements, put them in the list. Whenever it finds a non-continous 
 * element, we need to construct range summary from the list, clear 
 * the list, and then put the item in to list. Note that when the loop
 * finishes, we need to construct summaries from the remaining items 
 * in the list if there is any.
 */ 
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>(); 
        int len = nums.length; 
        
        if (len == 0) {
            return result; 
        }
        
        List<Integer> item = new ArrayList<>(); 
        item.add(nums[0]); 
        
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                item.add(nums[i]); 
            } else {
                // Need to get summary range
                int size = item.size(); 
                
                if (size == 1) {
                    result.add(String.valueOf(item.get(0))); 
                } else {
                    result.add(String.valueOf(item.get(0)) + "->" + String.valueOf(item.get(size - 1))); 
                }
                
                item.clear(); 
                item.add(nums[i]); 
            }
        }
        
        int size = item.size(); 
            
        if (size != 0) {    
            if (size == 1) {
                result.add(String.valueOf(item.get(0))); 
            } else {
                result.add(String.valueOf(item.get(0)) + "->" + String.valueOf(item.get(size - 1))); 
            }
            
            item.clear(); 
        }
        
        return result; 
    }
}
