public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        if (numRows == 0) {
            return result; 
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>(); 
        temp.add(1);
        result.add(temp);
        
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>(); 
            ArrayList<Integer> prevRow = result.get(i - 1); 
            
            for (int j = 1; j < prevRow.size(); j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j)); 
            }
            
            row.add(1);
            row.add(0, 1); 
            result.add(row); 
        }
        
        return result; 
    }
}
