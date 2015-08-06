import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array that could contain duplicates. Find all unique permutations. 
 * Sort the array first. Then solve it recursively. Put the result in a set 
 * before return. 
 */ 
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	Arrays.sort(nums);
        Set<List<Integer>> temp = helper(nums, 0); 
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        for (List<Integer> item : temp) {
        	result.add(item);
        }
        
        return result; 
    }
    
    private Set<List<Integer>> helper(int[] nums, int index) {
        int len = nums.length; 
        Set<List<Integer>> result = new HashSet<List<Integer>>(); 
        
        if (index == len) {
            return result; 
        }
        
        if (index == len - 1) {
            List<Integer> temp = new ArrayList<>(); 
            temp.add(nums[index]); 
            result.add(temp); 
            return result; 
        }
        
        Set<List<Integer>> temp = helper(nums, index + 1); 
        
        for (List<Integer> item : temp) {
            for (int i = 0; i < item.size(); i++) {
                if (i > 0 && nums[index] == item.get(i - 1)) {
                    continue;
                } else {
                    List<Integer> newitem = new ArrayList<>(item);
                    newitem.add(i, nums[index]);
                    result.add(newitem);
                }
            }
            
            if (nums[index] != item.get(item.size() - 1)) {
                item.add(nums[index]);
                result.add(item);
            }
        }
        
        return result; 
    }
}
