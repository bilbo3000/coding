import java.util.ArrayList;
import java.util.List;

/**
 * Find the combination of k numbers that add up to n, and 
 * we can only choose numbers 1 through 9. 
 * Solve it recursively. 
 */ 
public class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private int k; 
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        
        helper(1, new ArrayList<Integer>(), 0, n);
        
        return result;
    }
    
    private void helper(int num, List<Integer> list, int count, int sum) {
        
        if (sum == 0 && count == k) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return; 
        }
        
    	if (num >= 10 || count > k) {
    		return;
    	}
        
        // Not include current element 
        helper(num + 1, list, count, sum);
        
        // Try to include current element 
        if (num <= sum && num <= 9 && count < k) {
            list.add(num);
            helper(num + 1, list, count + 1, sum - num);
            list.remove(list.size() - 1);
        }
    }
    
}
