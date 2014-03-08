public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        
        return helper(S, S.length - 1); 
    }
    
    private ArrayList<ArrayList<Integer>> helper(int[] S, int index) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        if (index < 0) {
            result.add(new ArrayList<Integer>()); 
            return result; 
        }
        
        result = helper(S, index - 1);
        int size = result.size(); 
        
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i)); 
            temp.add(S[index]); 
            result.add(temp); 
        }
        
        return result; 
    }
}
