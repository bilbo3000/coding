public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer> > result = new ArrayList<List<Integer> >(); 
        
        if (numRows <= 0) {
            return result; 
        }
        
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                result.add(new ArrayList<Integer>(Arrays.asList(1))); 
            } else {
                List<Integer> prev = result.get(i - 1);
                List<Integer> curr = new ArrayList<Integer>(); 
                curr.add(1);
                
                for (int j = 0; j < prev.size() - 1; j++) {
                    curr.add(prev.get(j) + prev.get(j + 1)); 
                }
                
                curr.add(1); 
                result.add(curr); 
            }
        }
        
        return result; 
    }
}
