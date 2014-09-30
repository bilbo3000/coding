public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        if (numRows == 0) {
            return result; 
        }
        
        List<Integer> firstRow = new ArrayList<Integer>(); 
        firstRow.add(1);
        result.add(firstRow); 
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> prevRow = result.get(i - 1); 
            
            for (int j = 0; j < prevRow.size() - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1)); 
            }
            
            row.add(0, 1);
            row.add(1);
            result.add(row); 
        }
        
        return result; 
    }
}
