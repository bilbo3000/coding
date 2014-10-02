public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        if (k == 0) {
            return result; 
        }
        
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> temp = new ArrayList<Integer>(); 
                temp.add(i);
                result.add(temp); 
            }
            
            return result; 
        }
        
        for (int i = n - 1; i >= k - 1; i--) {
            List<List<Integer>> temp = combine(i, k - 1); 
            
            for (List<Integer> item : temp) {
                item.add(i + 1); 
            }
            
            result.addAll(temp); 
        }
        
        return result; 
    }
}
