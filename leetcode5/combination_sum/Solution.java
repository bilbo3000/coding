public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); 
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        Set<List<Integer>> temp = new HashSet<List<Integer>>(); 
        
        helper(candidates, 0, new ArrayList<Integer>(), 0, target, temp); 
        
        result.addAll(temp);
        
        return result; 
    }
    
    private void helper(int[] candidates, int index, List<Integer> path, int sum, int target, Set<List<Integer>> result) {
        if (sum == target && !result.contains(path)) {
            result.add(new ArrayList<Integer>(path)); 
            return; 
        }
        
        if (sum > target || index >= candidates.length) {
            return; 
        }
        
        // Not choose current element 
        helper(candidates, index + 1, path, sum, target, result); 
        
        // Choose current element 
        List<Integer> temp = new ArrayList<Integer>(path);
        temp.add(candidates[index]); 
        helper(candidates, index, temp, sum + candidates[index], target, result); 
    }
}
