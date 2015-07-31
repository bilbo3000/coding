import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all combination of elements that add up to the given target. 
 * Note that each element can be used as many times as you want. 
 * Solve it recursively. The idea was that for current, there are 
 * two choices: include it or not include it. When not indlude it, we 
 * just need to advance by increase the index by 1; Then we try to 
 * include, iff that element is less than the remaining sum. We add 
 * that element to the list, subtract from the target, and recursively 
 * move on with the SAME index, because we may include this element again.
 * Don't forget to remove the element you just added after recursive call
 * returns.
 */ 
public class Solution {
    private Set<List<Integer>> history = new HashSet<List<Integer>>(); 

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, 0, new ArrayList<Integer>(), target); 
        
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        for (List<Integer> item : history) {
            result.add(item);
        }
        
        return result; 
    }
    
    private void helper(int[] candidates, int index, List<Integer> list, int sum) {
        if (index >= candidates.length && sum != 0) {
            return; 
        }
        
        if (sum == 0) {
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            history.add(temp);
            return;
        }
        
        // Do not include current element
        helper(candidates, index + 1, list, sum);
        
        // Include current element 
        if (candidates[index] <= sum) {
            list.add(candidates[index]);
            helper(candidates, index, list, sum - candidates[index]); 
            list.remove(list.size() - 1);
        }
    }
}
