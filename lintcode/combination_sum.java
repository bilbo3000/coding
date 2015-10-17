public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<List<Integer>>(); 
        helper(candidates, target, new ArrayList<Integer>(), 0, set, 0);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        result.addAll(set);
        
        return result; 
    }
    
    private void helper(int[] candidates, int target, List<Integer> sol, int sum, Set<List<Integer>> list, int index) {
        if (target == sum) {
            list.add(new ArrayList<Integer>(sol));
            return; 
        }
        
        if (sum > target) {
            return; 
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                sol.add(candidates[i]);
                helper(candidates, target, sol, sum + candidates[i], list, i);
                sol.remove(sol.size() - 1);
            } else {
                return; 
            }
        }
    }
}
