public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size(); 
        
        if (height == 0) {
            return 0; 
        }
        
        List<Integer> row = new ArrayList<Integer>(triangle.get(height - 1)); 
        
        for (int i = height - 2; i >= 0; i--) {
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                int min = Math.min(currRow.get(j) + row.get(j), currRow.get(j) + row.get(j + 1));
                row.set(j, min); 
            }
        }
        
        return row.get(0); 
    }
}
