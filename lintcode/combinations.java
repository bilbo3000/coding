public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		Set<List<Integer>> temp = helper(1, n, k);
		List<List<Integer>> result = new ArrayList<List<Integer>>(); 
		
		for (List<Integer> item : temp) {
		    result.add(item);
		}
		
		return result; 
    }
    
    private Set<List<Integer>> helper(int index, int n, int k) {
        Set<List<Integer>> result = new HashSet<List<Integer>>(); 
                    
        if (k == 1) {
            for (int i = index; i <= n; i++) {
                List<Integer> item = new ArrayList<>(); 
                item.add(i);
                result.add(item);
            }
            
            return result; 
        } else {
            for (int i = index; i <= n - k + 1; i++) {
                Set<List<Integer>> temp = helper(i + 1, n, k - 1);
                
                for (List<Integer> item : temp) {
                    item.add(0, i);
                    result.add(item);
                }
            }
            
            return result; 
        }
    }
}
