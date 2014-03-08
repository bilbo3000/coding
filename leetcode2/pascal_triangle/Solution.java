public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        if (numRows == 0) return result; 
        
        ArrayList<Integer> level = new ArrayList<Integer>(); 
        level.add(1); 
        result.add(level); 
        
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(); 
            ArrayList<Integer> prev = result.get(i - 1); 
            temp.add(1);
            
            for (int j = 0; j < prev.size() - 1; j++) {
                temp.add(prev.get(j) + prev.get(j + 1)); 
            }
            
            temp.add(1);
            result.add(temp); 
        }
        
        return result; 
    }
}
