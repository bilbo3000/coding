/*
Find all the combinations from an array sum to the given number. 

Solve it using recursion. Keep track of current list and all the current
results collected so far. And keep track of the remaining sum. 

Add current list to the results collection once remaining sum becomes zero. 
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> results = new HashSet<List<Integer>>(); 
        helper(candidates, 0, target, new ArrayList<Integer>(), results);
        List<List<Integer>> res = new ArrayList<List<Integer>>(results); 
        return res; 
    }
    
    private void helper(int[] candidates, int index, int target, List curr, Set<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(curr));
            return; 
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                curr.add(candidates[i]);
                helper(candidates, i, target - candidates[i], curr, results);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
