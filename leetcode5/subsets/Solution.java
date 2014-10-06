public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S); 
        return helper(S, 0); 
    }
    
    private List<List<Integer>> helper(int[] S, int index) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        if (index == S.length) {
            result.add(new ArrayList<Integer>()); 
            
            return result; 
        }
        
        int digit = S[index]; 
        result = helper(S, index + 1);
        
        for (int i = result.size() - 1; i >= 0; i--) {
            List<Integer> temp = new ArrayList<Integer>(result.get(i));
            temp.add(0, digit);
            result.add(temp); 
        }
        
        return result; 
    }
}
