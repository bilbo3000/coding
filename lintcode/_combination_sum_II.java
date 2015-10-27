public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        helper(new ArrayList<Integer>(), num, target, result, 0); 
        return result; 
    }
    
    private void helper(List<Integer> sol, int[] num, int target, List<List<Integer>> result, int pos) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(sol)); 
            return; 
        }
        
        if (pos >= num.length || num[pos] > target) {
            return; 
        }
        
        int prev = -1; 
        
        for (int i = pos; i < num.length; i++) {
            if (num[i] != prev) {
                // The idea here is that if the current element is the same as 
                // its previous element, then there is no need to go down the 
                // recursion from this element, because all elements going down 
                // form this element MUST have been covered by the previous 
                // element. Thus there is no need to recursion on it again. 
                sol.add(num[i]);
                helper(sol, num, target - num[i], result, i + 1);
                sol.remove(sol.size() - 1);
                prev = num[i]; 
            }
        }
    }
}

