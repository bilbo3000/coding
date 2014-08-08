public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length; 
        List<List<Integer> > result = new ArrayList<List<Integer> >(); 
        if (len == 0) {
            return result; 
        }
        
        Arrays.sort(candidates);
        Set<List<Integer> > temp = new HashSet<List<Integer> >(); 
        helper(candidates, target, 0, new ArrayList<Integer>(), temp); 
        result.addAll(temp);
        return result; 
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> path, Set<List<Integer> > result) {
        int len = candidates.length; 
        if (index >= len || target <= 0) {
            return; 
        }
        
        for (int i = index; i < len; i++) {
            path.add(candidates[i]);
            if (candidates[i] == target) {
                result.add(new ArrayList<Integer>(path));
            } else {
                helper(candidates, target - candidates[i], i, path, result);
            }
            path.remove(path.size() - 1); 
        }
    }
}
