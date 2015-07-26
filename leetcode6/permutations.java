/**
 * Find all the permutations for a given list of numbers. 
 * The idea was to first calculate the permutations for n - 1 digits, 
 * then insert current digit at every possible positions of the result. 
 * Note that there could be duplicates, so use a set to eliminate 
 * duplicates. Return the overall results when finishing insert the 
 * last digit. 
 */ 
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length; 
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        if (len == 0) {
            return result; 
        }
        
        Set<List<Integer>> prev = new HashSet<List<Integer>>(); 
        Set<List<Integer>> curr = new HashSet<List<Integer>>(); 
        
        for (int i = 0; i < len; i++) {
            int digit = nums[i]; 
            
            if (i == 0) {
                List<Integer> temp = new ArrayList<>(); 
                temp.add(digit);
                curr.add(temp); 
            } else {
                for (List<Integer> item : prev) {
                    for (int j = 0; j < item.size(); j++) {
                        List<Integer> temp = new ArrayList<>(item);  
                        temp.add(j, digit); 
                        curr.add(temp); 
                    }
                    
                    List<Integer> temp = new ArrayList<>(item); 
                    temp.add(digit); 
                    curr.add(temp); 
                }
            }
            
            // Switch prev and curr 
            prev.clear(); 
            Set<List<Integer>> temp = prev; 
            prev = curr; 
            curr = temp; 
        }
        
        result.addAll(prev); 
        
        return result; 
    }
}
