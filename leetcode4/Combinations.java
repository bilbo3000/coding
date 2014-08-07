public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer> > result = new ArrayList<List<Integer> >(); 
        
        if (k == 0) {
            return result; 
        }
        
        if (n == 0) {
            return null; 
        }
        
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                result.add(new ArrayList<Integer>(Arrays.asList(i))); 
            }
            
            return result; 
        } else {
            for (int i = 1; i <= n - k + 1; i++) {
                List<List<Integer> > temp = combine(n - i, k - 1); 
                for (List<Integer> item : temp) {
                    item.add(n - i + 1); 
                }
                
                result.addAll(temp);
            } 
            
            return result; 
        }
    }
}
