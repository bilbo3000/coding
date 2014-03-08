public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        if (candidates.length == 0) {
            return result; 
        }
        
        Arrays.sort(candidates); 
        
        return helper(candidates, 0, target); 
    }
    
    private ArrayList<ArrayList<Integer>> helper(int[] candidates, int index, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        int len = candidates.length; 
        int i = index; 
        
        while(i < len) {
            if (candidates[i] == target) {
                ArrayList<Integer> temp = new ArrayList<Integer>(); 
                temp.add(candidates[i]); 
                result.add(temp); 
            }
            else if (candidates[i] < target) {
                ArrayList<ArrayList<Integer>> temp = helper(candidates, i, target - candidates[i]); 
                
                for (ArrayList<Integer> item : temp) {
                    item.add(0, candidates[i]); 
                }
                
                result.addAll(temp); 
            }
            
            do {
                i++; 
            } while (i < len && candidates[i] == candidates[i - 1]); 
        }
        
        return result; 
    }
}
