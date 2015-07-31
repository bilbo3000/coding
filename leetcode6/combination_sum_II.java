import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all combinations from an array elements that sum up to the given 
 * that and no element can be used more than once. 
 * Solve it recursively. The idea was that for each element, we have two 
 * choices, include it (if possible) or not. Different from previous problem,
 * we always move on to next index no matter we choose current element or not
 * because no more elements can be used more than once. Also, don't forget to
 * remove the elements we added after the recursive call returns
 */
public class Solution {
    private Set<List<Integer>> history = new HashSet<List<Integer>>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        
        // Try include the current element 
        if (candidates[index] <= sum) {
            list.add(candidates[index]);
            helper(candidates, index + 1, list, sum - candidates[index]);
            list.remove(list.size() - 1);
        }
    }
}
