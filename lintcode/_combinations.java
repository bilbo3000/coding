public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     * 
     * Solve it recursively. The idea was at each level of recursion, for each 
     * element starting from start index to the end n, add that element to 
     * current solution and pass it on the next recursion call with incremental
     * start index. Remove the value once recursive call returns. Add solution 
     * to result list once the solution has size k. 
     * 
     * Note that the candidates are from 1 to n, thus there could not be
     * duplicates. 
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, new ArrayList<Integer>(), 1, n, k);
		return result; 
    }
    
    private void helper(List<List<Integer>> result, List<Integer> solution, int start, int n, int k) {
        
        if (solution.size() == k) {
            // Found a solution
            result.add(new ArrayList<Integer>(solution));
            return; 
        }
        
        for (int i = start; i <= n; i++) {
            solution.add(i);
            helper(result, solution, i + 1, n, k);
            solution.remove(solution.size() - 1);
        }
    }
}
