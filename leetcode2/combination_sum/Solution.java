public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); 
        ArrayList<Integer> curr = new ArrayList<Integer>(); 
    	helper(curr, candidates, 0, target); 
        
        return result; 
    }
    
    public void helper(ArrayList<Integer> curr, int[] candidates, int index, int target) {
        if (target == 0) {
            result.add(curr); 
            return; 
        }
        
        if (target < 0 || index > candidates.length - 1) return; 
        
        // Add current element 
        ArrayList<Integer> curr1 = new ArrayList<Integer>(curr); 
        curr1.add(candidates[index]); 
        helper(curr1, candidates, index, target - candidates[index]); 
        
        // Skip current element 
        helper(curr, candidates, index + 1, target); 
    }
}
