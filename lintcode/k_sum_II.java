public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        helper(A, k, target, 0, new ArrayList<Integer>(), result);
        
        return result; 
    }
    
    private void helper(int A[], int k, int target, int start, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> result) {
        
        if (sol.size() == k && target == 0) {
            result.add(new ArrayList<Integer>(sol));
            return; 
        }
        
        if (target < 0) {
            return; 
        }
        
        for (int i = start; i < A.length; i++) {
            if (sol.size() < k && A[i] <= target) {
                // Add current element 
                sol.add(A[i]);
                helper(A, k, target - A[i], i + 1, sol, result);
                sol.remove(sol.size() - 1);
            }
        }
    }
}

