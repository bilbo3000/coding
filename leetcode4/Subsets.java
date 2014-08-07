public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        return helper(S, 0); 
    }
    
    private List<List<Integer> > helper(int[] S, int index) {
        List<List<Integer> > result = new ArrayList<List<Integer> >(); 
        int len = S.length; 
        
        if (index == len) {
            result.add(new ArrayList<Integer>());
            return result; 
        }
        
        List<List<Integer> > temp = helper(S, index + 1); 
        result.addAll(temp); 
        
        for (List<Integer> item : temp) {
            List<Integer> l = new ArrayList<Integer>(item);
            l.add(0, S[index]);
            Collections.sort(l); 
            result.add(l); 
        }
        
        return result;
    }
}
